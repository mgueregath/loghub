/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.exceptions.auth.UnauthorizedException;
import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.exceptions.security.ForbiddenException;
import cl.emendare.starterkit.domain.security.contract.token.GenerateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.GetTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.InvalidateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.user.AuthUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import cl.emendare.starterkit.usecase.migration.data.Roles;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class AuthUser implements AuthUserInterface {

    private final GenerateTokenInterface generateToken;
    private final GetUserInterface getUser;
    private final PasswordHasherAdapter passwordHasher;
    private final InvalidateTokenInterface invalidateToken;
    private final GetTokenInterface getToken;

    @Inject
    public AuthUser(
            GenerateTokenInterface generateToken,
            GetUserInterface getUser,
            PasswordHasherAdapter passwordHasher,
            InvalidateTokenInterface invalidateToken,
            GetTokenInterface getToken
    ) {
        this.generateToken = generateToken;
        this.getUser = getUser;
        this.passwordHasher = passwordHasher;
        this.invalidateToken = invalidateToken;
        this.getToken = getToken;
    }

    @Override
    public Token login(String username, String password) {
        try {
            User user = getUser.getByUsername(username);
            if (!passwordHasher.validate(password, user.getPassword())) {
                throw new UnauthorizedException();
            }
            /*if (user.getStatus().getId() != UserStatuses.CHANGE_PASSWORD && user.getStatus().getId() != UserStatuses.ENABLED) {
                throw new UnauthorizedException();
            }*/
            return generateToken.generateForAuth(user);
        } catch (DataNotFoundException ex) {
            throw new UnauthorizedException();
        }

    }

    @Override
    public boolean logout(User user) {
        if (user.getRole().getDomainId() == Roles.PUBLIC) {
            throw new ForbiddenException();
        }
        List<Token> tokens = getToken.getValidByUser(user.getId(), 1);
        if (tokens != null) {
            for (Token tk : tokens) {
                invalidateToken.invalidate(tk);
            }
        }
        return true;
    }
}
