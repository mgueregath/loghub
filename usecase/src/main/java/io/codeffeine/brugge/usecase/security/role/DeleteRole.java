/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.role;

import io.codeffeine.brugge.domain.security.contract.role.DeleteRoleInterface;
import io.codeffeine.brugge.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.brugge.usecase.exception.businessrule.role.RoleIsNotDeletableException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class DeleteRole implements DeleteRoleInterface {

    private final RoleRepositoryInterface repository;
    private final GetRoleInterface getRole;

    @Inject
    public DeleteRole(
            RoleRepositoryInterface repository,
            GetRoleInterface getRole
    ) {
        this.repository = repository;
        this.getRole = getRole;
    }

    @Override
    public boolean delete(int id) {
        Role role = getRole.getById(id);

        if (!role.isDeletable()) {
            throw new RoleIsNotDeletableException();
        }
        return repository.delete(role);
    }
}
