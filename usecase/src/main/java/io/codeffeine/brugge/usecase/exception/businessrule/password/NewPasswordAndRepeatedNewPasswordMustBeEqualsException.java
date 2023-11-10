/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.password;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class NewPasswordAndRepeatedNewPasswordMustBeEqualsException extends RuntimeException implements MappedException {

    public NewPasswordAndRepeatedNewPasswordMustBeEqualsException() {
        super("The new password and the repeated new password have to be equals");
    }
}
