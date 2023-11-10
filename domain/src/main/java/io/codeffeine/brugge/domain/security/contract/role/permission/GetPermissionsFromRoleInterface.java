/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.role.permission;

import io.codeffeine.brugge.domain.security.entity.SecureMethod;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetPermissionsFromRoleInterface {

    public List<SecureMethod> getByRole(int roleId);
}
