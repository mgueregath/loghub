/*
 * StarterKit.
 */
package cl.emendare.starterkit.persistence.postgresql.repository;

import cl.emendare.exceptions.persistence.PersistingException;
import cl.emendare.starterkit.domain.mailing.entity.Email;
import cl.emendare.starterkit.domain.mailing.repository.EmailRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.PostgreSQLSession;
import com.google.inject.Inject;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class EmailRepository implements EmailRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public EmailRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public List<Email> findByDate(Date date) {
        Session session = sessionFactory.openSession();
        List<Email> emails = session
                .createQuery("SELECT e FROM Email e WHERE e.date = :date")
                .setParameter("date", date)
                .getResultList();
        session.close();
        return emails;
    }

    @Override
    public List<Email> findByAddress(String address) {
        Session session = sessionFactory.openSession();
        List<Email> emails = session
                .createQuery("SELECT e FROM Email e WHERE e.to = :to")
                .setParameter("to", address)
                .getResultList();
        session.close();
        return emails;
    }

    @Override
    public Email persist(Email email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            email = (Email) session.merge(email);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException();
        } finally {
            session.close();
        }
        return email;
    }
}
