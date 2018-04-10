/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role.permission;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface RemovePermissionFromRoleInterface {

    public boolean remove(int roleId, int serviceId, int methodId);
}
