/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.user;

import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.domain.security.contract.token.GenerateTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.token.GetTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.token.InvalidateTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.user.AuthUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.GetUserInterface;
import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import io.codeffeine.starterkit.usecase.exception.auth.UnauthorizedException;
import io.codeffeine.starterkit.usecase.exception.security.ForbiddenException;
import io.codeffeine.starterkit.domain.migration.data.Roles;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
            if (!user.isEnabled() || (user.getAccountRecovery() != null && user.getAccountRecovery())) {
                throw new UnauthorizedException();
            }
            if (!passwordHasher.validate(password, user.getPassword())) {
                throw new UnauthorizedException();
            }
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
