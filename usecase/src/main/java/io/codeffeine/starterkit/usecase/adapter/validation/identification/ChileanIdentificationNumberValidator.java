/*
 * Tasty.
 */
package io.codeffeine.starterkit.usecase.adapter.validation.identification;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ChileanIdentificationNumberValidator implements IdentificationNumberValidatorAdapter {

    @Override
    public boolean validate(String idNumber) {
        try {
            idNumber = idNumber.toUpperCase();
            idNumber = idNumber.replace(".", "");
            idNumber = idNumber.replace("-", "");
            int rutAux = Integer.parseInt(idNumber.substring(0, idNumber.length() - 1));

            char dv = idNumber.charAt(idNumber.length() - 1);

            int m = 0;
            int s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                return true;
            }
            return false;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
