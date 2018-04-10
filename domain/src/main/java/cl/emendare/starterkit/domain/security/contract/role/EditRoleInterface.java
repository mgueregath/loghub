/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role;

import cl.emendare.starterkit.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface EditRoleInterface {

    public Role edit(int id, String name);
}
