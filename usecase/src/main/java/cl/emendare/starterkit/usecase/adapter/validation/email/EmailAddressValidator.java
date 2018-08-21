/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.adapter.validation.email;

import cl.emendare.starterkit.usecase.exception.validation.EmailAddressValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class EmailAddressValidator implements EmailAddressValidatorAdapter {

    private final Pattern pattern;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailAddressValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        throw new EmailAddressValidationException();
    }
}
