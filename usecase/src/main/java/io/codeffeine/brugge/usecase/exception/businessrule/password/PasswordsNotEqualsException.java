/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.password;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PasswordsNotEqualsException extends RuntimeException implements MappedException {

    public PasswordsNotEqualsException() {
        super("The suministried password have to be equals");
    }
}
