/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.jwt;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class JwtGenerationException extends RuntimeException implements MappedException {

    public JwtGenerationException() {
        super("The token could not be generated");
    }
}
