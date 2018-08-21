/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.exception.businessrule.password;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class CurrentPasswordAndNewPasswordAreEqualsException extends RuntimeException implements MappedException {

    public CurrentPasswordAndNewPasswordAreEqualsException() {
        super("The new password is iquals to current password. Have to be different");
    }
}
