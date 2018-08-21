/*
 * StarterKit.
 */
package cl.emendare.starterkit.persistence.postgresql.repository;

import cl.emendare.starterkit.persistence.exception.PersistingException;
import cl.emendare.starterkit.domain.security.repository.SecureMethodRepositoryInterface;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import cl.emendare.starterkit.persistence.exception.DeletingException;
import cl.emendare.starterkit.persistence.postgresql.PostgreSQLSession;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class SecureMethodRepository implements SecureMethodRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public SecureMethodRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public List<SecureMethod> findAll() {
        Session session = sessionFactory.openSession();
        List<SecureMethod> methods = session
                .createQuery("SELECT s FROM SecureMethod s ORDER BY s.method.service ASC, s.method ASC")
                .getResultList();
        session.close();
        if (methods.isEmpty()) {
            return null;
        }
        return methods;
    }

    @Override
    public List<SecureMethod> findByService(int service) {
        Session session = sessionFactory.openSession();
        List<SecureMethod> methods = session
                .createQuery("SELECT s FROM SecureMethod s WHERE s.method.service = :service")
                .setParameter("service", service)
                .getResultList();
        session.close();
        if (methods.isEmpty()) {
            return null;
        }
        return methods;
    }

    @Override
    public SecureMethod findByServiceAndMethod(int service, int methodId) {
        Session session = sessionFactory.openSession();
        List<SecureMethod> methods = session
                .createQuery("SELECT s FROM SecureMethod s WHERE s.method.service = :service AND s.method.method = :method")
                .setParameter("service", service)
                .setParameter("method", methodId)
                .getResultList();
        session.close();
        if (methods.isEmpty()) {
            return null;
        }
        return methods.get(0);
    }

    @Override
    public SecureMethod findById(int id) {
        Session session = sessionFactory.openSession();
        SecureMethod evidenceDocument = session.get(SecureMethod.class, id);
        session.close();
        return evidenceDocument;
    }

    @Override
    public SecureMethod persist(SecureMethod method) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            method = (SecureMethod) session.merge(method);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException(e.getCause());
        } finally {
            session.close();
        }
        return method;
    }

    @Override
    public List<SecureMethod> persist(List<SecureMethod> methods) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (SecureMethod method : methods) {
                Collections.replaceAll(methods, method, (SecureMethod) session.merge(method));
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException(e.getCause());
        }
        return methods;
    }

    @Override
    public boolean remove(SecureMethod method) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(method);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DeletingException();
        }
        return true;
    }
}
