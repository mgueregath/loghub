/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.jwt;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class JwtValidationException extends RuntimeException implements MappedException {

    public JwtValidationException() {
        super("The authorization token is not valid");
    }
}
