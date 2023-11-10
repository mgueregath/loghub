/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.role;

import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import io.codeffeine.brugge.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.domain.security.repository.RoleRepositoryInterface;
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
