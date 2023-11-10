/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.user;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface RecoverUserPasswordInterface {

    public boolean recover(String username);
}
