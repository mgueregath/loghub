/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.token;

import cl.emendare.starterkit.domain.security.contract.token.GetTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.ValidateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.usecase.adapter.jwt.JwtAdapter;
import cl.emendare.starterkit.usecase.exception.auth.UnauthorizedException;
import cl.emendare.starterkit.usecase.exception.jwt.JwtValidationException;
import cl.emendare.starterkit.usecase.exception.jwt.MalformedJwtException;
import cl.emendare.starterkit.domain.migration.data.Roles;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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

    private void checkGrammar(String tokenString) {
        if (tokenString == null) {
            throw new MalformedJwtException();
        }

        if (!tokenString.startsWith("Bearer ")) {
            throw new MalformedJwtException();
        }

        if (tokenString.split(" ").length != 2) {
            throw new MalformedJwtException();
        }
    }

    private User validate(String tokenString, int type) {
        if (tokenString == null) {
            return publicUser;
        }
        checkGrammar(tokenString);

        tokenString = tokenString.split(" ")[1];

        try {
            long tokenId = jwt.validate(tokenString, Keys.getAuthKey());
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
        checkGrammar(tokenString);
        tokenString = tokenString.split(" ")[1];

        try {
            long tokenId = jwt.validate(tokenString, Keys.getAuthKey());
            return getToken.getById(tokenId);
        } catch (JwtValidationException e) {
            throw new UnauthorizedException();
        }
    }
}
