/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role.permission;

import cl.emendare.starterkit.usecase.exception.data.AlreadyExistException;
import cl.emendare.starterkit.domain.security.contract.method.GetSecureMethodInterface;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.AddPermissionToRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class AddPermissionToRole implements AddPermissionToRoleInterface {

    private final RoleRepositoryInterface repository;
    private final GetRoleInterface getRole;
    private final GetSecureMethodInterface getSecureMethod;

    @Inject
    public AddPermissionToRole(
            RoleRepositoryInterface repository,
            GetRoleInterface getRole,
            GetSecureMethodInterface getSecureMethod
    ) {
        this.repository = repository;
        this.getRole = getRole;
        this.getSecureMethod = getSecureMethod;
    }

    @Override
    public Role add(int roleId, int serviceId, int methodId) {
        Role role = getRole.getById(roleId);
        SecureMethod method = getSecureMethod.getByServiceAndMethod(serviceId, methodId);
        for (SecureMethod m : role.getPermissions()) {
            if (m.getMethod().getService() == serviceId && m.getMethod().getMethod() == methodId) {
                throw new AlreadyExistException();
            }
        }
        role.getPermissions().add(method);
        return repository.persist(role);
    }

}
