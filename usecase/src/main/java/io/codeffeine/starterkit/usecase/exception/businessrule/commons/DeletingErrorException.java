/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.commons;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class DeletingErrorException extends RuntimeException implements MappedException {

    public DeletingErrorException() {
        super("An error has occurred deleting the requested data");
    }
}
