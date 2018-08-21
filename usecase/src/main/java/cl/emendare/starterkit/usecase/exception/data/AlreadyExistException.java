/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.data;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class AlreadyExistException extends RuntimeException implements MappedException {

    public AlreadyExistException() {
        super("This already exist");
    }
}
