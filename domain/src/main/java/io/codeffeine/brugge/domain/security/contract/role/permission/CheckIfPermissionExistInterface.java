/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.role.permission;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface CheckIfPermissionExistInterface {

    public boolean check(int roleId, int serviceId, int methodId);
}
