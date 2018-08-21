/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.validation;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class EmailAddressValidationException extends RuntimeException implements MappedException {

    public EmailAddressValidationException() {
        super("Invalid email address");
    }
}
