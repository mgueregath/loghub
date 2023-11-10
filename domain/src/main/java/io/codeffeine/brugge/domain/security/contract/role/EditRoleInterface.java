/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.role;

import io.codeffeine.brugge.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface EditRoleInterface {

    public Role edit(int id, String name);
}
