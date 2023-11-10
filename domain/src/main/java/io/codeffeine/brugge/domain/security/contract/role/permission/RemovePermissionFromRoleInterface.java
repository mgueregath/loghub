/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.role.permission;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface RemovePermissionFromRoleInterface {

    public boolean remove(int roleId, int serviceId, int methodId);
}
