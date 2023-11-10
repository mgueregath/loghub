/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.password;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PasswordNotChangedException extends RuntimeException implements MappedException {

    public PasswordNotChangedException() {
        super("The password has not been changed");
    }
}
