/*
 * StarterKit.
 */
package io.codeffeine.starterkit.persistence.postgresql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PostgreSQLSession {

    private static SessionFactory sessionFactory;

    public PostgreSQLSession() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void stop() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
