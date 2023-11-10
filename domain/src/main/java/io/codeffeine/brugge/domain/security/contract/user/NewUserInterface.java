/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.user;

import io.codeffeine.brugge.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewUserInterface {

    public User add(String username, String password, String repeatedPassword, String email, int roleId);
}
