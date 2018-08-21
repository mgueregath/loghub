/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.jwt;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class JwtGenerationException extends RuntimeException implements MappedException {

    public JwtGenerationException() {
        super("The token could not be generated");
    }
}
