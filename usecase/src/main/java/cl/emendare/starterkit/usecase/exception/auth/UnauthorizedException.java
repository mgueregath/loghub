/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.auth;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class UnauthorizedException extends RuntimeException implements MappedException {

    public UnauthorizedException() {
        super("You do not have permissions to access");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
