/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role.permission;

import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.CheckIfPermissionExistInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class CheckIfPermissionExist implements CheckIfPermissionExistInterface {

    private final GetRoleInterface getRole;
    private final RoleRepositoryInterface repository;

    @Inject
    public CheckIfPermissionExist(
            RoleRepositoryInterface repository,
            GetRoleInterface getRole
    ) {
        this.getRole = getRole;
        this.repository = repository;
    }

    @Override
    public boolean check(int roleId, int serviceId, int methodId) {
        Role role = getRole.getById(roleId);
        return repository.checkIfRoleHasPermission(role, serviceId, methodId);
    }

}
