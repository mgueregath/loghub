/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.user;

import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface ChangeRoleToUserInterface {

    public User changeRole(int userId, int roleId);
}
