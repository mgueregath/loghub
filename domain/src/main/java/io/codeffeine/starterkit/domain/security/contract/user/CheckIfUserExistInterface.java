/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.user;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface CheckIfUserExistInterface {

    public boolean checkByUsername(String username);
}
