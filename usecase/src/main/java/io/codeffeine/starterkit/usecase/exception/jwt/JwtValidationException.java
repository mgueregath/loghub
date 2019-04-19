/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.jwt;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class JwtValidationException extends RuntimeException implements MappedException {

    public JwtValidationException() {
        super("The authorization token is not valid");
    }
}
