/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.token;

import io.codeffeine.brugge.domain.security.entity.Token;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface InvalidateTokenInterface {

    public boolean invalidate(Token token);
}
