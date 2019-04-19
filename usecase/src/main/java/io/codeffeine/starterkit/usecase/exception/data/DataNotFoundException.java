/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.data;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class DataNotFoundException extends RuntimeException implements MappedException {

    public DataNotFoundException() {
        super("The requested data was not found");
    }
}
