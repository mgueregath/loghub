/*
 * StarterKit.
 */
package cl.emendare.starterkit.persistence.postgresql.repository;

import cl.emendare.exceptions.persistence.DeletingException;
import cl.emendare.exceptions.persistence.PersistingException;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.PostgreSQLSession;
import com.google.inject.Inject;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class RoleRepository implements RoleRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public RoleRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public List<Role> findAll() {
        Session session = sessionFactory.openSession();
        List<Role> roles = session
                .createQuery("SELECT r FROM Role r WHERE r.id < 9990")
                .getResultList();
        session.close();
        return roles;
    }

    @Override
    public Role findById(int id) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }

    @Override
    public Role persist(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            role = (Role) session.merge(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException();
        } finally {
            session.close();
        }
        return role;
    }

    @Override
    public boolean delete(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DeletingException();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean checkIfRoleHasPermission(Role role, int service, int method) {
        Session session = sessionFactory.openSession();
        List<SecureMethod> methods = session
                .createQuery("SELECT p FROM Role r, IN(r.permissions) p WHERE p.method.service = :service AND p.method.method = :method AND r = :role")
                .setParameter("service", service)
                .setParameter("method", method)
                .setParameter("role", role)
                .getResultList();
        session.close();
        return !methods.isEmpty();
    }
}
