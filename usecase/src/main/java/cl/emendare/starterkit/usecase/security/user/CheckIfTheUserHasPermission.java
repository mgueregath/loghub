/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.starterkit.domain.security.contract.user.CheckIfTheUserHasPermissionInterface;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.usecase.keeper.PermissionsKeeper;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class CheckIfTheUserHasPermission implements CheckIfTheUserHasPermissionInterface {

    private final PermissionsKeeper permissionsKeeper;

    @Inject
    public CheckIfTheUserHasPermission(
            PermissionsKeeper permissionsKeeper
    ) {
        this.permissionsKeeper = permissionsKeeper;
    }

    @Override
    public boolean check(User user, int service, int method) {
        return permissionsKeeper.hasPermission(user, service, method);
    }
}
