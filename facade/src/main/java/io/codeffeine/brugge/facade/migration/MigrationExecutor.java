/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.migration;

import io.codeffeine.brugge.domain.migration.contract.PersistMigrationDataInterface;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MigrationExecutor {

    private final PersistMigrationDataInterface persistMigrationData;

    @Inject
    public MigrationExecutor(
            PersistMigrationDataInterface persistMigrationData
    ) {
        this.persistMigrationData = persistMigrationData;
    }

    public void execute() {
        persistMigrationData.persist();
    }
}
