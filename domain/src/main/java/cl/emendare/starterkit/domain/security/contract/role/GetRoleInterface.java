/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.role;

import cl.emendare.starterkit.domain.security.entity.Role;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetRoleInterface {

    public List<Role> getAll();

    public Role getById(int id);
}
