/*
 * StarterKit.
 */
package io.codeffeine.starterkit.persistence.postgresql;

import com.google.inject.Inject;
import io.codeffeine.starterkit.persistence.postgresql.configuration.DatabaseConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PostgreSQLSession {

    private static SessionFactory sessionFactory;

    @Inject
    public PostgreSQLSession(DatabaseConfiguration configuration) {
        if (sessionFactory == null) {
            Configuration config = new Configuration().configure();
            if (!configuration.getDefaultValues()) {
                config.setProperty("hibernate.hikari.dataSource.serverName", configuration.getServerName());
                config.setProperty("hibernate.hikari.dataSource.portNumber", configuration.getPort() + "");
                config.setProperty("hibernate.hikari.dataSource.databaseName", configuration.getDatabaseName());
                config.setProperty("hibernate.hikari.dataSource.password", configuration.getPassword());
                config.setProperty("hibernate.hikari.dataSource.user", configuration.getUser());
            }
            sessionFactory = config.buildSessionFactory();
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
