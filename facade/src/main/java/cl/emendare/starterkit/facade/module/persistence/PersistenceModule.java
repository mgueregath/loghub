/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.persistence;

import cl.emendare.starterkit.domain.storage.repository.FileRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.PostgreSQLSession;
import cl.emendare.starterkit.persistence.storage.repository.FileRepository;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PostgreSQLSession.class);
        bind(FileRepositoryInterface.class).to(FileRepository.class);
    }
}
