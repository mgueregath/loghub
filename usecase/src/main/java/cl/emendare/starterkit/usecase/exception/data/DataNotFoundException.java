/*
 * Tasty.
 */
package cl.emendare.starterkit.usecase.exception.data;

import cl.emendare.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class DataNotFoundException extends RuntimeException implements MappedException {

    public DataNotFoundException() {
        super("The requested data was not found");
    }
}
