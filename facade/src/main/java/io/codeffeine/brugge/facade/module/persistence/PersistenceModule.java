/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.persistence;

import io.codeffeine.brugge.domain.storage.repository.FileRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;
import io.codeffeine.brugge.persistence.storage.repository.FileRepository;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PostgreSQLSession.class);
        bind(FileRepositoryInterface.class).to(FileRepository.class);
    }
}
