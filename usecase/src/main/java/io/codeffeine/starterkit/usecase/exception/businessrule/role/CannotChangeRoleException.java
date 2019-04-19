/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.role;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CannotChangeRoleException extends RuntimeException implements MappedException {

    public CannotChangeRoleException() {
        super("The role cannot be changed");
    }
}
