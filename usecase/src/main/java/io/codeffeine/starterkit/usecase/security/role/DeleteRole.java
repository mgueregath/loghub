/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.role;

import io.codeffeine.starterkit.domain.security.contract.role.DeleteRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.repository.RoleRepositoryInterface;
import io.codeffeine.starterkit.usecase.exception.businessrule.role.RoleIsNotDeletableException;
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
