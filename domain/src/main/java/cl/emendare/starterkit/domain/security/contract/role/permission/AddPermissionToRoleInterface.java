/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role.permission;

import cl.emendare.starterkit.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface AddPermissionToRoleInterface {

    public Role add(int roleId, int serviceId, int methodId);
}
