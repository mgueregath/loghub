/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.service;

import cl.emendare.starterkit.domain.security.contract.user.ChangeRoleToUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.NewUserInterface;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.permission.ServiceIdentification;
import cl.emendare.starterkit.facade.permission.annotation.Permission;
import cl.emendare.starterkit.facade.permission.annotation.ProtectedService;
import cl.emendare.starterkit.usecase.migration.data.Roles;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@ProtectedService(
        service = ServiceIdentification.USERS
)
public class UserService {

    private final GetUserInterface getUser;
    private final NewUserInterface newUser;
    private final CheckIfUserExistInterface checkIfUserExist;
    private final ChangeRoleToUserInterface changeRoleToUser;

    @Inject
    public UserService(
            GetUserInterface getUser,
            NewUserInterface newUser,
            CheckIfUserExistInterface checkIfUserExist,
            ChangeRoleToUserInterface changeRoleToUser
    ) {
        this.getUser = getUser;
        this.newUser = newUser;
        this.checkIfUserExist = checkIfUserExist;
        this.changeRoleToUser = changeRoleToUser;
    }

    @Permission(
            details = "Ver los usuarios",
            method = 1
    )
    public List<User> getUsers(User user) {
        return getUser.getAll();
    }

    @Permission(
            details = "Ver los usuarios por rol",
            method = 2
    )
    public List<User> getUsersByRole(User user, int role) {
        return getUser.getByRole(role);
    }

    @Permission(
            details = "Ver un usuario",
            method = 3
    )
    public User getUser(User user, int userId) {
        return getUser.getById(userId);
    }

    @Permission(
            details = "Añadir un usuario",
            method = 4,
            roles = {Roles.PUBLIC}
    )
    public User newUser(User user, String username, String password, String repeatedPassword, String email, int role) {
        return newUser.add(username, password, repeatedPassword, email, role);
    }

    @Permission(
            details = "Cambiar el rol a un usuario",
            method = 5
    )
    public User changeRole(User user, int userId, int role) {
        return changeRoleToUser.changeRole(userId, role);
    }

    @Permission(
            details = "Verificar si un usuario existe",
            method = 6
    )
    public boolean checkIfUserExist(User user, String username) {
        return checkIfUserExist.checkByUsername(username);
    }

    @Permission(
            details = "Buscar usuarios",
            method = 7
    )
    public List<User> searchUser(User user, String search) {
        return getUser.search(search);
    }

    @Permission(
            details = "Ver los usuarios paginados",
            method = 8
    )
    public List<User> getPaginatedUsers(User user, int page) {
        return getUser.getPaginated(page);
    }
}
