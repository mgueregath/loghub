/*
 * Tasty.
 */
package cl.emendare.starterkit.persistence.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class DeletingException extends RuntimeException {

    public DeletingException() {
        super("An error has occurred deleting the entity");
    }
}
