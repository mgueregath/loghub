/*
 * Emendare product for an specific client.
 */
package io.codeffeine.starterkit.facade.environment;

import io.codeffeine.starterkit.external.mailing.MailingConfiguration;
import io.codeffeine.starterkit.facade.security.AuthServerConfiguration;
import io.codeffeine.starterkit.persistence.postgresql.configuration.DatabaseConfiguration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class Environment {

    private DatabaseConfiguration database;
    private MailingConfiguration smtpMailing;
    private AuthServerConfiguration authConfiguration;

    /**
     * @return the database
     */
    public DatabaseConfiguration getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    /**
     * @return the smtpMailing
     */
    public MailingConfiguration getSmtpMailing() {
        return smtpMailing;
    }

    /**
     * @param smtpMailing the smtpMailing to set
     */
    public void setSmtpMailing(MailingConfiguration smtpMailing) {
        this.smtpMailing = smtpMailing;
    }

    /**
     * @return the authConfiguration
     */
    public AuthServerConfiguration getAuthConfiguration() {
        return authConfiguration;
    }

    /**
     * @param authConfiguration the authConfiguration to set
     */
    public void setAuthConfiguration(AuthServerConfiguration authConfiguration) {
        this.authConfiguration = authConfiguration;
    }
}
