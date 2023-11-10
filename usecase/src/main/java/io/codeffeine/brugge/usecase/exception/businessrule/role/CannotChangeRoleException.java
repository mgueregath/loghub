/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.role;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CannotChangeRoleException extends RuntimeException implements MappedException {

    public CannotChangeRoleException() {
        super("The role cannot be changed");
    }
}
