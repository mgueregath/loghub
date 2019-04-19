/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.adapter.validation.field;

import io.codeffeine.starterkit.usecase.exception.validation.ParameterValidationException;
import java.util.Date;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class FieldValidator implements FieldValidatorAdapter {

    @Override
    public boolean validate(String... strings) {
        for (String st : strings) {
            if (st == null || st.equals("")) {
                throw new ParameterValidationException();
            }
        }
        return true;
    }

    @Override
    public boolean validate(Date... dates) {
        for (Date date : dates) {
            if (date == null) {
                throw new ParameterValidationException();
            }
        }
        return true;
    }
}
