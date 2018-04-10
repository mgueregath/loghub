/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.migration.repository;

import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface MigrationDataRepositoryInterface {

    public <T> List<T> getByClass(Class<T> targetClass);

    public <T> T getByClassAndDomainId(Class<T> targetClass, int id);

    public Object persist(Class targetClass, Object element);
}
