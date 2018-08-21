/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.exception.businessrule.password;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PasswordsNotEqualsException extends RuntimeException implements MappedException {

    public PasswordsNotEqualsException() {
        super("The suministried password have to be equals");
    }
}
