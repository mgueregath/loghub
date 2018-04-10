/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.user;

import cl.emendare.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface ChangeUserPasswordInterface {

    public User changePassword(User user, String currentPassword, String newPassword, String repeatedPassword);
}
