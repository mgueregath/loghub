/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.repository;

import io.codeffeine.starterkit.domain.security.entity.Role;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface RoleRepositoryInterface {

    public List<Role> findAll();

    public Role findById(int id);

    public Role persist(Role role);

    public boolean checkIfRoleHasPermission(Role role, int service, int method);

    public boolean delete(Role role);
}
