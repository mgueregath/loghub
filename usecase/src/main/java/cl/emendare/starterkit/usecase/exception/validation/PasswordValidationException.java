/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.validation;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PasswordValidationException extends RuntimeException implements MappedException {

    public PasswordValidationException() {
        super("Both password must be equals and have to have 4 characteres as least");
    }
}
