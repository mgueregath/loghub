/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.security;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ForbiddenException extends RuntimeException implements MappedException {

    public ForbiddenException() {
        super("You don't have the necessary permissions to perform this action or access to the requested information");
    }
}
