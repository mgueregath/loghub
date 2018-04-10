/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.user;

import cl.emendare.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface ChangeRoleToUserInterface {

    public User changeRole(int userId, int roleId);
}
