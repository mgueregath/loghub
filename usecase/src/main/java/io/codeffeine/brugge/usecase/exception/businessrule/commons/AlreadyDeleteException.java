/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.businessrule.commons;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class AlreadyDeleteException extends RuntimeException implements MappedException {

    public AlreadyDeleteException() {
        super("This is already deleted");
    }
}
