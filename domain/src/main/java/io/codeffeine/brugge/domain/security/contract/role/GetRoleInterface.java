/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.role;

import io.codeffeine.brugge.domain.security.entity.Role;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetRoleInterface {

    public List<Role> getAll();

    public Role getById(int id);
}
