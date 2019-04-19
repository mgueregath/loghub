/*
 * Tasty.
 */
package io.codeffeine.starterkit.persistence.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PersistingException extends RuntimeException {

    public PersistingException() {
        super("An error has occurred persisting the entity");
    }

    public PersistingException(Throwable t) {
        super("An error has occurred persisting the entity", t);
    }
}
