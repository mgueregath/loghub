/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.keeper;

import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import cl.emendare.starterkit.usecase.migration.data.Roles;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class PermissionsKeeper {

    private final GetRoleInterface getRole;
    private static Map<Integer, boolean[][]> permissions;

    @Inject
    private PermissionsKeeper(
            GetRoleInterface getRole
    ) {
        this.getRole = getRole;
        permissions = new HashMap<>();
    }

    public boolean hasPermission(User user, int service, int method) {
        if (!permissions.containsKey(user.getRole().getId())) {
            loadUserPermissions(user);
        }
        return permissions.get(user.getRole().getId())[service - 1][method - 1];
    }

    public void reloadAllPermissions() {
        permissions.clear();
    }

    private void loadUserPermissions(User user) {
        boolean[][] userPermissions = generatePermissionsMatrix(user);
        permissions.put(user.getRole().getId(), userPermissions);
    }

    private boolean[][] generatePermissionsMatrix(User user) {
        boolean[][] userPermissions = new boolean[CounterKeeper.getServices()][CounterKeeper.getMethods()];

        if (user.getRole().getDomainId() == Roles.DEVELOPMENT) {
            for (int i = 0; i < userPermissions.length; i++) {
                Arrays.fill(userPermissions[i], true);
            }
            return userPermissions;
        }

        try {
            Role role = getRole.getById(Roles.getById(Roles.PUBLIC).getId());
            for (SecureMethod method : role.getPermissions()) {
                userPermissions[method.getMethod().getService() - 1][method.getMethod().getMethod() - 1] = true;
            }
        } catch (Exception e) {
            // No action
        }
        if (user.getRole().getDomainId() != Roles.PUBLIC) {
            try {
                for (SecureMethod method : user.getRole().getPermissions()) {
                    userPermissions[method.getMethod().getService() - 1][method.getMethod().getMethod() - 1] = true;
                }
            } catch (Exception e) {
                // No action
            }
        }
        return userPermissions;

    }
}
