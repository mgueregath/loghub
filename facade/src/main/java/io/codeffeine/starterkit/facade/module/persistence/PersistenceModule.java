/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.persistence;

import io.codeffeine.starterkit.domain.storage.repository.FileRepositoryInterface;
import io.codeffeine.starterkit.persistence.postgresql.PostgreSQLSession;
import io.codeffeine.starterkit.persistence.storage.repository.FileRepository;
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
