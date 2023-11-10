/*
 * Tasty.
 */
package io.codeffeine.brugge.persistence.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class DeletingException extends RuntimeException {

    public DeletingException() {
        super("An error has occurred deleting the entity");
    }
}
