/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.adapter.password.hasher;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface PasswordHasherAdapter {

    public String hash(String password);

    public boolean validate(String password, String hashed);
}
