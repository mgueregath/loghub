/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.role;

import io.codeffeine.starterkit.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface EditRoleInterface {

    public Role edit(int id, String name);
}
