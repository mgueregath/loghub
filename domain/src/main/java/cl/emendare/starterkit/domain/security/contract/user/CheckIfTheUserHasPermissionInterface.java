/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.user;

import cl.emendare.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface CheckIfTheUserHasPermissionInterface {

    public boolean check(User user, int service, int method);

}
