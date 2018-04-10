/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role.permission;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface CheckIfPermissionExistInterface {

    public boolean check(int roleId, int serviceId, int methodId);
}
