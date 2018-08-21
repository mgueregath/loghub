/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.exception.businessrule.password;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class NewPasswordAndRepeatedNewPasswordMustBeEqualsException extends RuntimeException implements MappedException {

    public NewPasswordAndRepeatedNewPasswordMustBeEqualsException() {
        super("The new password and the repeated new password have to be equals");
    }
}
