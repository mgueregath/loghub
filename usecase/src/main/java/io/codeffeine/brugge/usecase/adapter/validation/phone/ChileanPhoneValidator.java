/*
 * Tasty.
 */
package io.codeffeine.brugge.usecase.adapter.validation.phone;

import io.codeffeine.brugge.usecase.exception.validation.PhoneNumberValidationException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ChileanPhoneValidator implements PhoneValidatorAdapter {

    private final Map<String, Integer> areaCodes = new HashMap<>();

    public ChileanPhoneValidator() {
        areaCodes.put("58", 58);
        areaCodes.put("57", 57);
        areaCodes.put("55", 55);
        areaCodes.put("52", 52);
        areaCodes.put("51", 51);
        areaCodes.put("53", 53);
        areaCodes.put("35", 35);
        areaCodes.put("33", 33);
        areaCodes.put("34", 34);
        areaCodes.put("32", 32);
        areaCodes.put("72", 72);
        areaCodes.put("71", 71);
        areaCodes.put("73", 73);
        areaCodes.put("75", 75);
        areaCodes.put("42", 42);
        areaCodes.put("43", 43);
        areaCodes.put("41", 41);
        areaCodes.put("45", 45);
        areaCodes.put("65", 65);
        areaCodes.put("64", 64);
        areaCodes.put("61", 61);
        areaCodes.put("67", 67);
        areaCodes.put("63", 63);
        areaCodes.put("2", 2);
        areaCodes.put("9", 9);
    }

    @Override
    public boolean validate(Long phone) {
        if (phone == null) {
            throw new PhoneNumberValidationException();
        }
        String phoneString = Long.toString(phone);
        if (phoneString.length() != 11) {
            throw new PhoneNumberValidationException();
        }
        if (!phoneString.substring(0, 2).equalsIgnoreCase("56")) {
            throw new PhoneNumberValidationException();
        }
        if (areaCodes.get(phoneString.substring(2, 4)) == null && areaCodes.get(phoneString.substring(2, 3)) == null) {
            throw new PhoneNumberValidationException();
        }
        return true;
    }
}
