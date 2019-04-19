/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.jwt;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MalformedJwtException extends RuntimeException implements MappedException {

    public MalformedJwtException() {
        super("A malformed token has been provided");
    }
}
