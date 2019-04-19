/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.migration;

import io.codeffeine.starterkit.domain.migration.InitData;
import io.codeffeine.starterkit.domain.migration.contract.PersistMigrationDataInterface;
import io.codeffeine.starterkit.domain.migration.entity.MigratedEntity;
import io.codeffeine.starterkit.domain.migration.repository.MigrationDataRepositoryInterface;
import io.codeffeine.starterkit.usecase.sort.topological.DirectedGraph;
import io.codeffeine.starterkit.usecase.sort.topological.TolopogicalSort;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PersistMigrationData implements PersistMigrationDataInterface {

    private final MigrationDataRepositoryInterface repository;

    @Inject
    public PersistMigrationData(MigrationDataRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void persist() {
        Reflections reflections = new Reflections("io.codeffeine.starterkit.domain.migration.data");
        Set<Class<? extends InitData>> classes = reflections.getSubTypesOf(InitData.class);
        for (Class<? extends InitData> initData : classes) {
            try {
                Class.forName(initData.getCanonicalName()).newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                // No action
            }
        }
        DirectedGraph graph = new DirectedGraph();
        for (InitData initData : InitData.getInitData()) {
            graph.addNode(initData.getTargetClass().getCanonicalName());
            for (Field f : initData.getTargetClass().getDeclaredFields()) {
                if (f.getType().getPackage() != null && f.getType().getPackage().getName().contains("io.codeffeine.starterkit.domain")) {
                    graph.addNode(f.getType().getCanonicalName());
                    graph.addEdge(
                            f.getType().getCanonicalName(),
                            initData.getTargetClass().getCanonicalName()
                    );
                }
            }
        }
        List sorted = TolopogicalSort.sort(graph);
        for (Object node : sorted) {
            List<Object> persistedElements = new ArrayList<>();
            try {
                Class.forName(InitData.initDataHash.get((String) node).getClass().getCanonicalName()).newInstance();
                for (Object object : InitData.initDataHash.get((String) node).getData()) {
                    MigratedEntity obj = (MigratedEntity) object;
                    Object persisted = repository.getByClassAndDomainId(
                            InitData.initDataHash.get((String) node).getTargetClass(),
                            obj.getDomainId()
                    );

                    if (persisted == null) {
                        persisted = repository.persist(
                                InitData.initDataHash.get((String) node).getTargetClass(),
                                object
                        );
                    }
                    persistedElements.add(persisted);
                }
                InitData.initDataHash.get((String) node).setData(persistedElements);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                // No action
            }
        }
        /*if (!((String) node).equals(io.codeffeine.observatory.domain.entity.Person.class)) {

            }*/

    }
}
