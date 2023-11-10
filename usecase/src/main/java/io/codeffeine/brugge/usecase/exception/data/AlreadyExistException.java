/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.exception.data;

import io.codeffeine.brugge.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class AlreadyExistException extends RuntimeException implements MappedException {

    public AlreadyExistException() {
        super("This already exist");
    }
}
