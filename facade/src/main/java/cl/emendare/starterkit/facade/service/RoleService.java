/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.service;

import cl.emendare.starterkit.domain.security.contract.role.DeleteRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.EditRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.NewRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.AddPermissionToRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.GetPermissionsFromRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.RemovePermissionFromRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.permission.ServiceIdentification;
import cl.emendare.starterkit.facade.permission.annotation.Permission;
import cl.emendare.starterkit.facade.permission.annotation.ProtectedService;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@ProtectedService(
        service = ServiceIdentification.ROLES
)
public class RoleService {

    private final GetRoleInterface getRole;
    private final NewRoleInterface newRole;
    private final EditRoleInterface editRole;
    private final DeleteRoleInterface deleteRole;
    private final AddPermissionToRoleInterface addPermissionToRole;
    private final RemovePermissionFromRoleInterface removePermissionFromRole;
    private final GetPermissionsFromRoleInterface getPermissionsFromRole;

    @Inject
    public RoleService(
            GetRoleInterface getRole,
            NewRoleInterface newRole,
            EditRoleInterface editRole,
            DeleteRoleInterface deleteRole,
            AddPermissionToRoleInterface addPermissionToRole,
            RemovePermissionFromRoleInterface removePermissionFromRole,
            GetPermissionsFromRoleInterface getPermissionsFromRole
    ) {
        this.getRole = getRole;
        this.newRole = newRole;
        this.editRole = editRole;
        this.deleteRole = deleteRole;
        this.addPermissionToRole = addPermissionToRole;
        this.removePermissionFromRole = removePermissionFromRole;
        this.getPermissionsFromRole = getPermissionsFromRole;
    }

    @Permission(
            details = "Añadir un rol",
            method = 1
    )
    public Role newRole(User user, String name) {
        return newRole.add(name);
    }

    @Permission(
            details = "Editar un rol",
            method = 2
    )
    public Role editRole(User user, int role, String name) {
        return editRole.edit(role, name);
    }

    @Permission(
            details = "Ver un rol",
            method = 3
    )
    public Role getRole(User user, int role) {
        return getRole.getById(role);
    }

    @Permission(
            details = "Ver los roles",
            method = 4
    )
    public List<Role> getRoles(User user) {
        return getRole.getAll();
    }

    @Permission(
            details = "Eliminar un rol",
            method = 5
    )
    public boolean deleteRole(User user, int role) {
        return deleteRole.delete(role);
    }

    @Permission(
            details = "Ver los permisos de un rol",
            method = 6
    )
    public List<SecureMethod> getPermissionsByRole(User user, int role) {
        return getPermissionsFromRole.getByRole(role);
    }

    @Permission(
            details = "Añadir permiso a un rol",
            method = 7
    )
    public Role addPermissionToRole(User user, int role, int service, int method) {
        return addPermissionToRole.add(role, service, method);
    }

    @Permission(
            details = "Quitar permiso a un rol",
            method = 8
    )
    public boolean removePermissionToRole(User user, int role, int service, int method) {
        return removePermissionFromRole.remove(role, service, method);
    }
}
