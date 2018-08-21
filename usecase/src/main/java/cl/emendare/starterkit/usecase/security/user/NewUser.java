/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.starterkit.usecase.exception.data.AlreadyExistException;
import cl.emendare.starterkit.domain.security.contract.role.GetRoleInterface;
import cl.emendare.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import cl.emendare.starterkit.domain.security.contract.user.NewUserInterface;
import cl.emendare.starterkit.domain.security.entity.Role;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.repository.UserRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import cl.emendare.starterkit.usecase.adapter.validation.email.EmailAddressValidatorAdapter;
import cl.emendare.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import cl.emendare.starterkit.usecase.exception.businessrule.password.PasswordsNotEqualsException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class NewUser implements NewUserInterface {

    private final UserRepositoryInterface repository;
    private final CheckIfUserExistInterface checkIfUserExist;
    private final PasswordHasherAdapter passwordHasher;
    private final GetRoleInterface getRole;
    private final FieldValidatorAdapter fieldValidator;
    private final EmailAddressValidatorAdapter emailAddressValidator;

    @Inject
    public NewUser(
            UserRepositoryInterface repository,
            CheckIfUserExistInterface checkIfUserExist,
            PasswordHasherAdapter passwordHasher,
            GetRoleInterface getRole,
            FieldValidatorAdapter fieldValidator,
            EmailAddressValidatorAdapter emailAddressValidator
    ) {
        this.repository = repository;
        this.checkIfUserExist = checkIfUserExist;
        this.passwordHasher = passwordHasher;
        this.getRole = getRole;
        this.fieldValidator = fieldValidator;
        this.emailAddressValidator = emailAddressValidator;
    }

    @Override
    public User add(String username, String password, String repeatedPassword, String email, int roleId) {
        Role role = getRole.getById(roleId);
        /*
        if (admin.getRole().getId() != Roles.DEVELOPMENT && admin.getRole().getId() > role.getId()) {
            throw new ForbiddenException();
        }
        if (role.getId() == Roles.DEVELOPMENT || role.getId() == Roles.PUBLIC) {
            throw new ForbiddenException();
        }
         */
        fieldValidator.validate(username);
        emailAddressValidator.validate(email);
        if (checkIfUserExist.checkByUsername(username)) {
            throw new AlreadyExistException();
        }

        if (!password.equals(repeatedPassword)) {
            throw new PasswordsNotEqualsException();
        }

        User user = new User(username, passwordHasher.hash(password), email, role);
        user = repository.persist(user);
        return user;
    }
}
