/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role.permission;

import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetPermissionsFromRoleInterface {

    public List<SecureMethod> getByRole(int roleId);
}
