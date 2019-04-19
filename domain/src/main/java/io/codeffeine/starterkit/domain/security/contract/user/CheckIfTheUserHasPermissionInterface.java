/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.user;

import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface CheckIfTheUserHasPermissionInterface {

    public boolean check(User user, int service, int method);

}
