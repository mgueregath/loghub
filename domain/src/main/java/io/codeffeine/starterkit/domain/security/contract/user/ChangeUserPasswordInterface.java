/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.user;

import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface ChangeUserPasswordInterface {

    public User changePassword(User user, String currentPassword, String newPassword, String repeatedPassword);

    public boolean changePassword(String token, String password, String repeatedPassword);
}
