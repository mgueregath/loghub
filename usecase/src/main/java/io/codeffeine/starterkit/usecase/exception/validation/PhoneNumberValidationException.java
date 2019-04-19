/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.validation;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PhoneNumberValidationException extends RuntimeException implements MappedException {

    public PhoneNumberValidationException() {
        super("Invalid phone number");
    }
}
