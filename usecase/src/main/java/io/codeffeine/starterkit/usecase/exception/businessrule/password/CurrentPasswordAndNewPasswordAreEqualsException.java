/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.password;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CurrentPasswordAndNewPasswordAreEqualsException extends RuntimeException implements MappedException {

    public CurrentPasswordAndNewPasswordAreEqualsException() {
        super("The new password is iquals to current password. Have to be different");
    }
}
