/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.migration;

import cl.emendare.starterkit.domain.migration.contract.PersistMigrationDataInterface;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
