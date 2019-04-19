/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.service;

import io.codeffeine.starterkit.domain.security.contract.token.ValidateTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.user.AuthUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.RecoverUserPasswordInterface;
import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.facade.permission.ServiceIdentification;
import io.codeffeine.starterkit.facade.permission.annotation.Permission;
import io.codeffeine.starterkit.facade.permission.annotation.ProtectedService;
import io.codeffeine.starterkit.domain.migration.data.Roles;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
@ProtectedService(
        service = ServiceIdentification.AUTH
)
public class AuthenticationService {

    private final AuthUserInterface authUser;
    private final RecoverUserPasswordInterface recoverUserPassword;
    private final ValidateTokenInterface validateToken;

    @Inject
    public AuthenticationService(
            AuthUserInterface authUser,
            RecoverUserPasswordInterface recoverUserPassword,
            ValidateTokenInterface validateToken
    ) {
        this.authUser = authUser;
        this.recoverUserPassword = recoverUserPassword;
        this.validateToken = validateToken;
    }

    @Permission(
            details = "Iniciar sesión",
            method = 1,
            roles = {Roles.PUBLIC}
    )
    public Token loginUser(User user, String email, String password) {
        return authUser.login(email, password);
    }

    @Permission(
            details = "Cerrar sesión",
            method = 2,
            roles = {Roles.PUBLIC}
    )
    public boolean logoutUser(User user) {
        return authUser.logout(user);
    }

    @Permission(
            details = "Recuperar contraseña",
            method = 3,
            roles = {Roles.PUBLIC}
    )
    public boolean recoverUserPassword(User user, String username) {
        return recoverUserPassword.recover(username);
    }

    public User validateToken(String token) {
        return validateToken.validateForAuth(token);
    }

    public User validateTokenForPasswordRecovery(String token) {
        return validateToken.validateForSetPassword(token);
    }
}
