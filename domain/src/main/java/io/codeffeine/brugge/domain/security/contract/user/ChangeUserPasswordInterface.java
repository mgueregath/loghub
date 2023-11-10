/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.user;

import io.codeffeine.brugge.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface ChangeUserPasswordInterface {

    public User changePassword(User user, String currentPassword, String newPassword, String repeatedPassword);

    public boolean changePassword(String token, String password, String repeatedPassword);
}
