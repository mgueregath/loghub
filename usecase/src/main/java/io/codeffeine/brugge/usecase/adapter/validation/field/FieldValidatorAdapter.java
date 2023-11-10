/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.adapter.validation.field;

import java.util.Date;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface FieldValidatorAdapter {

    public boolean validate(String... strings);

    public boolean validate(Date... dates);
}
