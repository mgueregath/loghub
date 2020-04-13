/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.token;

import io.codeffeine.starterkit.domain.security.contract.token.GetTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.token.ValidateTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.user.GetUserInterface;
import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.usecase.adapter.jwt.JwtAdapter;
import io.codeffeine.starterkit.usecase.exception.auth.UnauthorizedException;
import io.codeffeine.starterkit.usecase.exception.jwt.JwtValidationException;
import io.codeffeine.starterkit.usecase.exception.jwt.MalformedJwtException;
import io.codeffeine.starterkit.domain.migration.data.Roles;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ValidateToken implements ValidateTokenInterface {

    private final GetTokenInterface getToken;
    private final JwtAdapter jwt;
    private final GetUserInterface getUser;
    private final User publicUser;

    @Inject
    public ValidateToken(
            GetTokenInterface getToken,
            JwtAdapter jwt,
            GetUserInterface getUser
    ) {
        this.getToken = getToken;
        this.jwt = jwt;
        this.getUser = getUser;
        publicUser = new User();
        publicUser.setRole(Roles.getById(Roles.PUBLIC));
    }

    @Override
    public User validateForAuth(String token) {
        return validate(token, 1);
    }

    @Override
    public User validateForSetPassword(String token) {
        return validate(token, 2);
    }

    private void checkGrammar(String tokenString, int type) {
        if (tokenString == null) {
            throw new MalformedJwtException();
        }

        if (type == 1 && !tokenString.startsWith("Bearer ")) {
            throw new MalformedJwtException();
        }

        if (type == 1 && tokenString.split(" ").length != 2) {
            throw new MalformedJwtException();
        }
    }

    private User validate(String tokenString, int type) {
        if (tokenString == null) {
            return publicUser;
        }
        checkGrammar(tokenString, type);

        if (type == 1) {
            tokenString = tokenString.split(" ")[1];
        }

        try {
            long tokenId = jwt.validate(tokenString, type == 1 ? Keys.getAuthKey() : Keys.getRecoveryKey());
            Token token = getToken.getById(tokenId);

            if (token.getStatus() != 1) {
                throw new JwtValidationException();
            }

            return getUser.getById(token.getUser().getId());
        } catch (JwtValidationException e) {
            throw new UnauthorizedException();
        }
    }

    @Override
    public Token getToken(String tokenString, int type) {
        checkGrammar(tokenString, type);
        tokenString = tokenString.split(" ")[1];

        try {
            long tokenId = jwt.validate(tokenString, type == 1 ? Keys.getAuthKey() : Keys.getRecoveryKey());
            return getToken.getById(tokenId);
        } catch (JwtValidationException e) {
            throw new UnauthorizedException();
        }
    }
}
