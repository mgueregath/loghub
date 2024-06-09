/*
 * Emendare product for an specific client.
 */
package io.codeffeine.brugge.facade.module.environment;

import com.google.inject.AbstractModule;
import io.codeffeine.brugge.external.mailing.MailingConfiguration;
import io.codeffeine.brugge.facade.environment.Environment;
import io.codeffeine.brugge.persistence.elastic.configuration.ElasticConfiguration;
import io.codeffeine.brugge.persistence.postgresql.configuration.DatabaseConfiguration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class EnvironmentModule extends AbstractModule {

    private final Environment environment;

    public EnvironmentModule(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(DatabaseConfiguration.class).toInstance(this.environment != null ? this.environment.getDatabase() : new DatabaseConfiguration());
        bind(MailingConfiguration.class).toInstance(this.environment != null ? this.environment.getSmtpMailing() : new MailingConfiguration());
        bind(ElasticConfiguration.class).toInstance(this.environment != null ? this.environment.getElastic() : null);
    }

}
