/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.password;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CurrentPasswordAndNewPasswordAreEqualsException extends RuntimeException implements MappedException {

    public CurrentPasswordAndNewPasswordAreEqualsException() {
        super("The new password is iquals to current password. Have to be different");
    }
}
