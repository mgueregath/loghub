/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.password;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PasswordsNotEqualsException extends RuntimeException implements MappedException {

    public PasswordsNotEqualsException() {
        super("The suministried password have to be equals");
    }
}
