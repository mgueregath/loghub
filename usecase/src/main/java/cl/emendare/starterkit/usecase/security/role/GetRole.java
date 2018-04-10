/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.role;

import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.repository.RoleRepositoryInterface;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetRole implements GetRoleInterface {

    private final RoleRepositoryInterface repository;

    @Inject
    public GetRole(
            RoleRepositoryInterface repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = repository.findAll();
        if (roles == null) {
            throw new DataNotFoundException();
        }
        return roles;
    }

    @Override
    public Role getById(int id) {
        Role role = repository.findById(id);
        if (role == null) {
            throw new DataNotFoundException();
        }
        return role;
    }
}
