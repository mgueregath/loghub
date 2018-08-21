/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.security;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ForbiddenException extends RuntimeException implements MappedException {

    public ForbiddenException() {
        super("You don't have the necessary permissions to perform this action or access to the requested information");
    }
}
