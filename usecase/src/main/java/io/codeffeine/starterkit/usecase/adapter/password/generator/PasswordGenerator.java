/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.adapter.password.generator;

import java.util.Random;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class PasswordGenerator implements PasswordGeneratorAdapter {

    private static final String SALTCHARS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
    StringBuilder salt = new StringBuilder();
    Random rnd;

    @Override
    public String generate() {
        rnd = new Random();
        while (salt.length() < 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
