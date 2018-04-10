/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.adapter.password.hasher;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface PasswordHasherAdapter {

    public String hash(String password);

    public boolean validate(String password, String hashed);
}
