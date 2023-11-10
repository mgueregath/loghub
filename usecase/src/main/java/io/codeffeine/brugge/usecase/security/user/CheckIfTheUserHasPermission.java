/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.user;

import io.codeffeine.brugge.domain.security.contract.user.CheckIfTheUserHasPermissionInterface;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.usecase.keeper.PermissionsKeeper;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
