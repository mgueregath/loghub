/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.exception.businessrule.commons;

import io.codeffeine.starterkit.domain.exception.MappedException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class StartDateIsGreaterThanEndDateException extends RuntimeException implements MappedException {

    public StartDateIsGreaterThanEndDateException() {
        super("The start date is less than the end date");
    }
}
