/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.validation;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PasswordValidationException extends RuntimeException implements MappedException {

    public PasswordValidationException() {
        super("Both password must be equals and have to have 4 characteres as least");
    }
}
