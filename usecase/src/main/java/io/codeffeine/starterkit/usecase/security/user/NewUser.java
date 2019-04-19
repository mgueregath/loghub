/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.user;

import io.codeffeine.starterkit.usecase.exception.data.AlreadyExistException;
import io.codeffeine.starterkit.domain.security.contract.role.GetRoleInterface;
import io.codeffeine.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import io.codeffeine.starterkit.domain.security.contract.user.NewUserInterface;
import io.codeffeine.starterkit.domain.security.entity.Role;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.domain.security.repository.UserRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import io.codeffeine.starterkit.usecase.adapter.validation.email.EmailAddressValidatorAdapter;
import io.codeffeine.starterkit.usecase.adapter.validation.field.FieldValidatorAdapter;
import io.codeffeine.starterkit.usecase.exception.businessrule.password.PasswordsNotEqualsException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
