/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.role;

import io.codeffeine.starterkit.domain.security.entity.Role;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetRoleInterface {

    public List<Role> getAll();

    public Role getById(int id);
}
