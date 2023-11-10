/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.validation;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class IdentificationNumberValidationException extends RuntimeException implements MappedException {

    public IdentificationNumberValidationException() {
        super("Invalid rut");
    }
}
