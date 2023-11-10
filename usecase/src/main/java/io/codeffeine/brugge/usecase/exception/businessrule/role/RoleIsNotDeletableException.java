/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.role;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class RoleIsNotDeletableException extends RuntimeException implements MappedException {

    public RoleIsNotDeletableException() {
        super("This role cannot be deleted to the new one");
    }
}
