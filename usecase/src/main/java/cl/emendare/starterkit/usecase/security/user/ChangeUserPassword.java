/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.starterkit.domain.security.contract.token.ValidateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.user.ChangeUserPasswordInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.repository.UserRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import cl.emendare.starterkit.usecase.exception.auth.UnauthorizedException;
import cl.emendare.starterkit.usecase.exception.businessrule.password.CurrentPasswordAndNewPasswordAreEqualsException;
import cl.emendare.starterkit.usecase.exception.businessrule.password.NewPasswordAndRepeatedNewPasswordMustBeEqualsException;
import cl.emendare.starterkit.usecase.exception.businessrule.password.PasswordNotChangedException;
import cl.emendare.starterkit.usecase.exception.security.ForbiddenException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ChangeUserPassword implements ChangeUserPasswordInterface {

    private final GetUserInterface getUser;
    private final UserRepositoryInterface repository;
    private final PasswordHasherAdapter passwordHasher;
    private final ValidateTokenInterface validateToken;

    @Inject
    public ChangeUserPassword(
            GetUserInterface getUser,
            UserRepositoryInterface repository,
            PasswordHasherAdapter passwordHasher,
            ValidateTokenInterface validateToken
    ) {
        this.getUser = getUser;
        this.repository = repository;
        this.passwordHasher = passwordHasher;
        this.validateToken = validateToken;
    }

    @Override
    public User changePassword(User user, String currentPassword, String newPassword, String repeatedPassword) {
        user = getUser.getById(user.getId());
        if (!passwordHasher.validate(currentPassword, user.getPassword())) {
            throw new ForbiddenException();
        }
        if (!newPassword.equals(repeatedPassword)) {
            throw new NewPasswordAndRepeatedNewPasswordMustBeEqualsException();
        }
        if (passwordHasher.validate(newPassword, user.getPassword())) {
            throw new CurrentPasswordAndNewPasswordAreEqualsException();
        }
        user.setPassword(passwordHasher.hash(newPassword));
        repository.persist(user);
        if (passwordHasher.validate(newPassword, user.getPassword())) {
            user.setPassword(null);
            return user;
        }
        throw new PasswordNotChangedException();
    }

    @Override
    public boolean changePassword(String token, String password, String repeatedPassword) {
        User user = validateToken.validateForSetPassword(token);
        if (!user.getAccountRecovery()) {
            throw new UnauthorizedException();
        }
        if (!password.equals(repeatedPassword)) {
            throw new NewPasswordAndRepeatedNewPasswordMustBeEqualsException();
        }

        user.setPassword(passwordHasher.hash(password));
        user.setAccountRecovery(false);
        user = repository.persist(user);
        if (passwordHasher.validate(password, user.getPassword())) {
            return true;
        }
        throw new PasswordNotChangedException();
    }
}
