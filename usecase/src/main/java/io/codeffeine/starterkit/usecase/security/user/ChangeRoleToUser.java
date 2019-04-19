/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.user;

import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.user.ChangeRoleToUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.GetUserInterface;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.domain.security.repository.UserRepositoryInterface;
import io.codeffeine.starterkit.usecase.exception.businessrule.role.CannotChangeRoleException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ChangeRoleToUser implements ChangeRoleToUserInterface {

    private final GetUserInterface getUser;
    private final UserRepositoryInterface repository;
    private final GetRoleInterface getRole;
    //private final NewEmailInterface newEmail;

    @Inject
    public ChangeRoleToUser(
            GetUserInterface getUser,
            UserRepositoryInterface repository,
            GetRoleInterface getRole
    //NewEmailInterface newEmail
    ) {
        this.getUser = getUser;
        this.repository = repository;
        this.getRole = getRole;
        //this.newEmail = newEmail;
    }

    @Override
    public User changeRole(int userId, int roleId) {
        User user = getUser.getById(userId);
        Role role = getRole.getById(roleId);
        Role oldRole = user.getRole();
        if (user.getRole().equals(role)) {
            throw new CannotChangeRoleException();
        }
        user.setRole(role);
        user = repository.persist(user);
        /*
        newEmail.add(
                    user.getPerson().getEmail(),
                    user.getPerson().getFirstName() + " " + user.getPerson().getFirstLastName(),
                    "Su rol en el sistema ha sido modificado",
                    "Junto con saludar, le informamos el rol que usted posee en el sistema ha"
                    + " sido modificado de <b> " + oldRole.getName()
                    + " </b> a <b> " + role.getName() + "</b>."
            );
         */
        return user;
    }
}
