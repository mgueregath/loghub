/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.migration;

import io.codeffeine.starterkit.domain.migration.contract.PersistMigrationDataInterface;
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
