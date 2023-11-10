/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.validation;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ParameterValidationException extends RuntimeException implements MappedException {

    public ParameterValidationException() {
        super("All requested parameters must be provided");
    }

    public ParameterValidationException(String reason) {
        super(reason);
    }
}
