/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.role;

import io.codeffeine.starterkit.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewRoleInterface {

    public Role add(String name);
}
