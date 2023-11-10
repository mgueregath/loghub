/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.role;

import io.codeffeine.brugge.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewRoleInterface {

    public Role add(String name);
}
