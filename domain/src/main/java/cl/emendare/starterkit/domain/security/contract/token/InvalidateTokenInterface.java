/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.token;

import cl.emendare.starterkit.domain.security.entity.Token;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface InvalidateTokenInterface {

    public boolean invalidate(Token token);
}
