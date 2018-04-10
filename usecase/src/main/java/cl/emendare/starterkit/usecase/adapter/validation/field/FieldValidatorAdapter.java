/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.adapter.validation.field;

import java.util.Date;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface FieldValidatorAdapter {

    public boolean validate(String... strings);

    public boolean validate(Date... dates);
}
