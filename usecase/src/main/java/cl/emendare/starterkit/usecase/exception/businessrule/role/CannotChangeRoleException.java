/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.exception.businessrule.role;

import cl.emendare.exceptions.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class CannotChangeRoleException extends RuntimeException implements MappedException {

    public CannotChangeRoleException() {
        super("The role cannot be changed");
    }
}
