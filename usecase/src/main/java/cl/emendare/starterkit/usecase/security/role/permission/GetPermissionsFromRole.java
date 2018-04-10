/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role.permission;

import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.GetPermissionsFromRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetPermissionsFromRole implements GetPermissionsFromRoleInterface {

    private final GetRoleInterface getRole;

    @Inject
    public GetPermissionsFromRole(GetRoleInterface getRole) {
        this.getRole = getRole;
    }

    @Override
    public List<SecureMethod> getByRole(int roleId) {
        Role role = getRole.getById(roleId);
        if (role.getPermissions().isEmpty()) {
            throw new DataNotFoundException();
        }
        return new ArrayList<>(role.getPermissions());
    }

}
