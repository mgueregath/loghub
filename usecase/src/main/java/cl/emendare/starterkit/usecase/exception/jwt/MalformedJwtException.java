/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.jwt;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class MalformedJwtException extends RuntimeException implements MappedException {

    public MalformedJwtException() {
        super("A malformed token has been provided");
    }
}
