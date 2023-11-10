/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.migration;

import io.codeffeine.brugge.domain.migration.contract.PersistMigrationDataInterface;
import io.codeffeine.brugge.domain.migration.repository.MigrationDataRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.repository.MigrationDataRepository;
import io.codeffeine.brugge.usecase.migration.PersistMigrationData;
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
