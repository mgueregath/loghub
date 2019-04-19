/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.jwt;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class JwtInvalidationException extends RuntimeException implements MappedException {

    public JwtInvalidationException() {
        super("An error has occurred during the token invalidation");
    }
}
