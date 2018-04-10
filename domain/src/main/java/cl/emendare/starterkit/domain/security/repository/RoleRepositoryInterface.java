/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.repository;

import cl.emendare.starterkit.domain.security.entity.Role;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface RoleRepositoryInterface {

    public List<Role> findAll();

    public Role findById(int id);

    public Role persist(Role role);

    public boolean checkIfRoleHasPermission(Role role, int service, int method);

    public boolean delete(Role role);
}
