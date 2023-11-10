/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.auth;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class UnauthorizedException extends RuntimeException implements MappedException {

    public UnauthorizedException() {
        super("You do not have permissions to access");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
