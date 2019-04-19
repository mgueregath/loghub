/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.security;

import io.codeffeine.starterkit.domain.security.contract.role.DeleteRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.EditRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.NewRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.permission.AddPermissionToRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.permission.CheckIfPermissionExistInterface;
import io.codeffeine.starterkit.domain.security.contract.role.permission.GetPermissionsFromRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.permission.RemovePermissionFromRoleInterface;
import io.codeffeine.starterkit.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.starterkit.persistence.postgresql.repository.RoleRepository;
import io.codeffeine.starterkit.usecase.security.role.DeleteRole;
import io.codeffeine.starterkit.usecase.security.role.EditRole;
import io.codeffeine.starterkit.usecase.security.role.GetRole;
import io.codeffeine.starterkit.usecase.security.role.NewRole;
import io.codeffeine.starterkit.usecase.security.role.permission.AddPermissionToRole;
import io.codeffeine.starterkit.usecase.security.role.permission.CheckIfPermissionExist;
import io.codeffeine.starterkit.usecase.security.role.permission.GetPermissionsFromRole;
import io.codeffeine.starterkit.usecase.security.role.permission.RemovePermissionFromRole;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
