/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.password;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class NewPasswordAndRepeatedNewPasswordMustBeEqualsException extends RuntimeException implements MappedException {

    public NewPasswordAndRepeatedNewPasswordMustBeEqualsException() {
        super("The new password and the repeated new password have to be equals");
    }
}
