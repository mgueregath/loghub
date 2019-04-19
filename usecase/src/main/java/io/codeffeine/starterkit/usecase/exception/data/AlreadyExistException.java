/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.data;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class AlreadyExistException extends RuntimeException implements MappedException {

    public AlreadyExistException() {
        super("This already exist");
    }
}
