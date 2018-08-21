/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.exception.businessrule.role;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class RoleIsNotDeletableException extends RuntimeException implements MappedException {

    public RoleIsNotDeletableException() {
        super("This role cannot be deleted to the new one");
    }
}
