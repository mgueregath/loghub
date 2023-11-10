/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.security;

import io.codeffeine.brugge.domain.security.contract.role.DeleteRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.EditRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.NewRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.permission.AddPermissionToRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.permission.CheckIfPermissionExistInterface;
import io.codeffeine.brugge.domain.security.contract.role.permission.GetPermissionsFromRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.permission.RemovePermissionFromRoleInterface;
import io.codeffeine.brugge.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.repository.RoleRepository;
import io.codeffeine.brugge.usecase.security.role.DeleteRole;
import io.codeffeine.brugge.usecase.security.role.EditRole;
import io.codeffeine.brugge.usecase.security.role.GetRole;
import io.codeffeine.brugge.usecase.security.role.NewRole;
import io.codeffeine.brugge.usecase.security.role.permission.AddPermissionToRole;
import io.codeffeine.brugge.usecase.security.role.permission.CheckIfPermissionExist;
import io.codeffeine.brugge.usecase.security.role.permission.GetPermissionsFromRole;
import io.codeffeine.brugge.usecase.security.role.permission.RemovePermissionFromRole;
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
