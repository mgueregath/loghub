/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.migration;

import io.codeffeine.starterkit.domain.migration.contract.PersistMigrationDataInterface;
import io.codeffeine.starterkit.domain.migration.repository.MigrationDataRepositoryInterface;
import io.codeffeine.starterkit.persistence.postgresql.repository.MigrationDataRepository;
import io.codeffeine.starterkit.usecase.migration.PersistMigrationData;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MigrationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MigrationDataRepositoryInterface.class).to(MigrationDataRepository.class);
        bind(PersistMigrationDataInterface.class).to(PersistMigrationData.class);
    }
}
