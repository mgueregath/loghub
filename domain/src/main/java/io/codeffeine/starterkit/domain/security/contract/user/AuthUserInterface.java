/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.user;

import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface AuthUserInterface {

    public Token login(String username, String password);

    public boolean logout(User user);
}
