/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.role.permission;

import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import io.codeffeine.brugge.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.permission.GetPermissionsFromRoleInterface;
import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.domain.security.entity.SecureMethod;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
