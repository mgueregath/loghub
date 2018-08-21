/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.jwt;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class JwtInvalidationException extends RuntimeException implements MappedException {

    public JwtInvalidationException() {
        super("An error has occurred during the token invalidation");
    }
}
