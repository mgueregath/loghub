/*
 * StarterKit.
 */
package io.codeffeine.starterkit.persistence.postgresql.repository;

import io.codeffeine.starterkit.persistence.exception.PersistingException;
import io.codeffeine.starterkit.persistence.exception.DeletingException;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.domain.security.repository.UserRepositoryInterface;
import io.codeffeine.starterkit.persistence.postgresql.PostgreSQLSession;
import com.google.inject.Inject;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class UserRepository implements UserRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public UserRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public User persist(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            user = (User) session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public boolean delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
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
    public User findById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List<User> users = session
                .createQuery("SELECT u FROM User u")
                .getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> findByRole(Role role) {
        Session session = sessionFactory.openSession();
        List<User> users = session
                .createQuery("SELECT u FROM User u WHERE u.role = :role")
                .setParameter("role", role)
                .getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> findPaginated(int page) {
        Session session = sessionFactory.openSession();
        List<User> user = session
                .createQuery("SELECT u FROM User u")
                .setFirstResult(page * 15)
                .setMaxResults(15)
                .getResultList();
        session.close();
        return user;
    }

    @Override
    public List<User> search(String search) {
        Session session = sessionFactory.openSession();
        List<User> users = session
                .createQuery(
                        "SELECT u FROM User u WHERE "
                        + "u.username LIKE :search "
                        + "GROUP BY u.id"
                ).setParameter("search", "%" + search + "%")
                .getResultList();
        session.close();
        return users;
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        List<User> users = session
                .createQuery("SELECT u FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getResultList();
        session.close();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }
}
