/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.security;

import cl.emendare.starterkit.domain.security.contract.role.DeleteRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.EditRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.NewRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.AddPermissionToRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.CheckIfPermissionExistInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.GetPermissionsFromRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.permission.RemovePermissionFromRoleInterface;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.repository.RoleRepository;
import cl.emendare.starterkit.usecase.security.role.DeleteRole;
import cl.emendare.starterkit.usecase.security.role.EditRole;
import cl.emendare.starterkit.usecase.security.role.GetRole;
import cl.emendare.starterkit.usecase.security.role.NewRole;
import cl.emendare.starterkit.usecase.security.role.permission.AddPermissionToRole;
import cl.emendare.starterkit.usecase.security.role.permission.CheckIfPermissionExist;
import cl.emendare.starterkit.usecase.security.role.permission.GetPermissionsFromRole;
import cl.emendare.starterkit.usecase.security.role.permission.RemovePermissionFromRole;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class RoleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RoleRepositoryInterface.class).to(RoleRepository.class);
        bind(GetRoleInterface.class).to(GetRole.class);
        bind(NewRoleInterface.class).to(NewRole.class);
        bind(EditRoleInterface.class).to(EditRole.class);
        bind(DeleteRoleInterface.class).to(DeleteRole.class);
        bind(AddPermissionToRoleInterface.class).to(AddPermissionToRole.class);
        bind(RemovePermissionFromRoleInterface.class).to(RemovePermissionFromRole.class);
        bind(GetPermissionsFromRoleInterface.class).to(GetPermissionsFromRole.class);
        bind(CheckIfPermissionExistInterface.class).to(CheckIfPermissionExist.class);
    }
}
