/*
 * Tasty.
 */
package io.codeffeine.brugge.persistence.postgresql.repository;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.notification.entity.Notification;
import io.codeffeine.brugge.domain.notification.repository.NotificationRepositoryInterface;
import io.codeffeine.brugge.persistence.exception.PersistingException;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class NotificationRepository implements NotificationRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public NotificationRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public Notification findById(long id) {
        Session session = sessionFactory.openSession();
        Notification notification = session.get(Notification.class, id);
        session.close();
        return notification;
    }

    @Override
    public List<Notification> findByParams(String text, int page, String param, String order) {
        Session session = sessionFactory.openSession();
        List<Notification> notifications = generateQuery(false, text, page, param, order).getResultList();
        session.close();
        return notifications;
    }

    @Override
    public Long countByParams(String text, int page, String param, String order) {
        Session session = sessionFactory.openSession();
        Long quantity = (Long) generateQuery(true, text, page, param, order).uniqueResult();
        session.close();
        return quantity;
    }

    @Override
    public Notification persist(Notification notification) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            notification = (Notification) session.merge(notification);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException();
        } finally {
            session.close();
        }
        return notification;
    }

    private Query generateQuery(boolean isCounting, String text, int page, String param, String order) {
        String queryString = "SELECT c FROM Notification c";
        if (isCounting) {
            queryString = "SELECT COUNT(c) FROM Notification c";
        }
        if (text != null) {
            queryString += " WHERE (lower(c.title) LIKE lower(:search) OR "
                    + "lower(c.content) LIKE lower(:search)";
        }
        if (text != null) {
            queryString += " GROUP BY c.id";
            if (param != null) {
                queryString += "GROUP BY c.id, c." + param;
            }
        } else if (param != null) {
            queryString += " GROUP BY c.id, c." + param;
        } else if (!isCounting) {
            //queryString += " GROUP BY c.id";
        }
        if (param != null && order != null) {
            queryString += " ORDER BY c." + param + " " + order;
        } else if (!isCounting) {
            queryString += " ORDER BY c.id DESC";
        }
        Session session = sessionFactory.openSession();
        Query query = session
                .createQuery(queryString);
        if (text != null) {
            query.setParameter("search", "%" + text + "%");
        }
        if (!isCounting) {
            query.setMaxResults(20).setFirstResult(20 * page);
        }
        return query;
    }
}
