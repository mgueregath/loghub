/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.validation;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class EmailAddressValidationException extends RuntimeException implements MappedException {

    public EmailAddressValidationException() {
        super("Invalid email address");
    }
}
