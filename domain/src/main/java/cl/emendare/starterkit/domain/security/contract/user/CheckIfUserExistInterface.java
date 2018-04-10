/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.user;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface CheckIfUserExistInterface {

    public boolean checkByUsername(String username);
}
