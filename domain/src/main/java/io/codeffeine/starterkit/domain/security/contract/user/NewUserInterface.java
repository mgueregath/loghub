/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.user;

import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewUserInterface {

    public User add(String username, String password, String repeatedPassword, String email, int roleId);
}
