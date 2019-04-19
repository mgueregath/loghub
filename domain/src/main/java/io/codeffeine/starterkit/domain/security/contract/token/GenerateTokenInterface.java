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
public interface GenerateTokenInterface {

    public Token generateForAuth(User user);

    public Token generateForSetPassword(User user);
}
