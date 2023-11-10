/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.user;

import io.codeffeine.brugge.domain.security.entity.Token;
import io.codeffeine.brugge.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface AuthUserInterface {

    public Token login(String username, String password);

    public boolean logout(User user);
}
