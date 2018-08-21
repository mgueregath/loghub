/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.exception.businessrule.password;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PasswordNotChangedException extends RuntimeException implements MappedException {

    public PasswordNotChangedException() {
        super("The password has not been changed");
    }
}
