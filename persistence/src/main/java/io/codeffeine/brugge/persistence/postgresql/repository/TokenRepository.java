/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.persistence.postgresql.repository;

import io.codeffeine.brugge.domain.security.entity.Token;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.domain.security.repository.TokenRepositoryInterface;
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
public class TokenRepository implements TokenRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public TokenRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public Token findById(long id) {
        Session session = sessionFactory.openSession();
        Token token = session.get(Token.class, id);
        session.close();
        return token;
    }

    @Override
    public Token persist(Token token) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            token = (Token) session.merge(token);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
        return token;
    }

    @Override
    public List<Token> findByUser(User user, int type) {
        Session session = sessionFactory.openSession();
        List<Token> tokens = session
                .createQuery("SELECT t FROM Token t WHERE t.user = :user AND t.type = :type")
                .setParameter("user", user)
                .setParameter("type", type)
                .getResultList();
        session.close();
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens;
    }

    @Override
    public List<Token> findValidByUser(User user, int type) {
        Session session = sessionFactory.openSession();
        List<Token> tokens = session
                .createQuery("SELECT t FROM Token t WHERE t.user = :user AND t.type = :type AND t.status = 1")
                .setParameter("user", user)
                .setParameter("type", type)
                .getResultList();
        session.close();
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens;
    }

    @Override
    public List<Token> findNotValidByUser(User user, int type) {
        Session session = sessionFactory.openSession();
        List<Token> tokens = session
                .createQuery("SELECT t FROM Token t WHERE t.user = :user AND t.type = :type AND t.status = 2")
                .setParameter("user", user)
                .setParameter("type", type)
                .getResultList();
        session.close();
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens;
    }
}
