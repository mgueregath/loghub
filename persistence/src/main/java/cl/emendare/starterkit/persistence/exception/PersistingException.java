/*
 * Tasty.
 */
package cl.emendare.starterkit.persistence.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PersistingException extends RuntimeException {

    public PersistingException() {
        super("An error has occurred persisting the entity");
    }

    public PersistingException(Throwable t) {
        super("An error has occurred persisting the entity", t);
    }
}
