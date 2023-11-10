/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.data;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class DataNotFoundException extends RuntimeException implements MappedException {

    public DataNotFoundException() {
        super("The requested data was not found");
    }
}
