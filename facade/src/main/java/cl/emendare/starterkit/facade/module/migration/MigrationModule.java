/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.migration;

import cl.emendare.starterkit.domain.migration.contract.PersistMigrationDataInterface;
import cl.emendare.starterkit.domain.migration.repository.MigrationDataRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.repository.MigrationDataRepository;
import cl.emendare.starterkit.usecase.migration.PersistMigrationData;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class MigrationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MigrationDataRepositoryInterface.class).to(MigrationDataRepository.class);
        bind(PersistMigrationDataInterface.class).to(PersistMigrationData.class);
    }
}
