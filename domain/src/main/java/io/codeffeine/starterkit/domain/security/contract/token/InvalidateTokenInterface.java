/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.token;

import io.codeffeine.starterkit.domain.security.entity.Token;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface InvalidateTokenInterface {

    public boolean invalidate(Token token);
}
