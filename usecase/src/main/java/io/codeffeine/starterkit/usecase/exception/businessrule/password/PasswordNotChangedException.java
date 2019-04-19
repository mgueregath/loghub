/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.password;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PasswordNotChangedException extends RuntimeException implements MappedException {

    public PasswordNotChangedException() {
        super("The password has not been changed");
    }
}
