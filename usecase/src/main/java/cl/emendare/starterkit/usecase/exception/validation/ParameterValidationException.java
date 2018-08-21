/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.validation;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ParameterValidationException extends RuntimeException implements MappedException {

    public ParameterValidationException() {
        super("All requested parameters must be provided");
    }

    public ParameterValidationException(String reason) {
        super(reason);
    }
}
