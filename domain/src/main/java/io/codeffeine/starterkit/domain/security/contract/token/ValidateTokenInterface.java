/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.token;

import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface ValidateTokenInterface {

    public User validateForAuth(String token);

    public User validateForSetPassword(String token);

    public Token getToken(String token, int type);
}
