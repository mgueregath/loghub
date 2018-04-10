/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role;

import cl.emendare.starterkit.domain.security.contract.role.DeleteRoleInterface;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import cl.emendare.starterkit.usecase.exception.businessrule.role.RoleIsNotDeletableException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
