/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.validation;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PhoneNumberValidationException extends RuntimeException implements MappedException {

    public PhoneNumberValidationException() {
        super("Invalid phone number");
    }
}
