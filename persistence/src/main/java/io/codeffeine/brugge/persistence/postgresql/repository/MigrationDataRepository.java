/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.persistence.postgresql.repository;

import io.codeffeine.brugge.domain.migration.repository.MigrationDataRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;
import com.google.inject.Inject;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MigrationDataRepository implements MigrationDataRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public MigrationDataRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public <T> List<T> getByClass(Class<T> targetClass) {
        Session session = sessionFactory.openSession();
        List<T> types = session
                .createQuery("SELECT b FROM " + targetClass.getName() + " b")
                .getResultList();
        session.close();
        return types;
    }

    @Override
    public <T> T getByClassAndDomainId(Class<T> targetClass, int id) {
        Session session = sessionFactory.openSession();
        List<T> types = session
                .createQuery("SELECT b FROM " + targetClass.getName() + " b WHERE b.domainId = :id")
                .setParameter("id", id)
                .getResultList();
        session.close();
        if (types.isEmpty()) {
            return null;
        }
        return types.get(0);
    }

    @Override
    public Object persist(Class targetClass, Object element) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            element = session.merge(targetClass.cast(element));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
        return element;
    }
}
