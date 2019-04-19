/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.role.permission;

import io.codeffeine.starterkit.domain.security.entity.Role;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface AddPermissionToRoleInterface {

    public Role add(int roleId, int serviceId, int methodId);
}
