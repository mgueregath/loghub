/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.role;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class RoleIsNotDeletableException extends RuntimeException implements MappedException {

    public RoleIsNotDeletableException() {
        super("This role cannot be deleted to the new one");
    }
}
