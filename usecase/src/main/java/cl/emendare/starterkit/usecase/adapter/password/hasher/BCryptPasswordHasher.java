/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.adapter.password.hasher;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class BCryptPasswordHasher implements PasswordHasherAdapter {

    @Override
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean validate(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
