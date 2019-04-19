/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.role;

import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.repository.RoleRepositoryInterface;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
