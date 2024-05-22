/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.adapter.jwt;

import com.auth0.jwt.JWT;
import io.codeffeine.brugge.usecase.exception.jwt.JwtGenerationException;
import io.codeffeine.brugge.usecase.exception.jwt.JwtValidationException;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Auth0Jwt implements JwtAdapter {

    @Override
    public String generate(long tokenId, int userId, int userAuth, String key) {
        String token;
        try {
            token = JWT.create()
                    .withIssuer("codeffeine")
                    .withNotBefore(new Date())
                    .withExpiresAt(DateUtils.addHours(new Date(), 10))
                    .withJWTId(Long.toString(tokenId))
                    .withClaim("user_id", userId)
                    .withClaim("auth", userAuth)
                    .sign(Algorithm.HMAC256(key));
            return token;
        } catch (JWTCreationException | UnsupportedEncodingException | IllegalArgumentException exception) {
            throw new JwtGenerationException();
        }
    }

    @Override
    public long validate(String token, String key) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key))
                    .withIssuer("codeffeine")
                    .build();
            JWT jwt = (JWT) verifier.verify(token);
            return Long.parseLong(jwt.getId());
        } catch (JWTVerificationException | UnsupportedEncodingException | IllegalArgumentException exception) {
            throw new JwtValidationException();
        }
    }
}
