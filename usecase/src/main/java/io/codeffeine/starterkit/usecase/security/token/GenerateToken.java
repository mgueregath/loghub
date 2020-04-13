/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.token;

import io.codeffeine.starterkit.domain.security.contract.token.GenerateTokenInterface;
import io.codeffeine.starterkit.domain.security.contract.token.InvalidateTokenInterface;
import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.domain.security.repository.TokenRepositoryInterface;
import io.codeffeine.starterkit.usecase.adapter.jwt.JwtAdapter;
import com.google.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class GenerateToken implements GenerateTokenInterface {

    private final TokenRepositoryInterface tokenRepository;
    private final InvalidateTokenInterface invalidateToken;
    private final JwtAdapter jwtAdapter;

    @Inject
    public GenerateToken(
            TokenRepositoryInterface tokenRepository,
            JwtAdapter jwtAdapter,
            InvalidateTokenInterface invalidateToken
    ) {
        this.tokenRepository = tokenRepository;
        this.jwtAdapter = jwtAdapter;
        this.invalidateToken = invalidateToken;
    }

    @Override
    public Token generateForAuth(User user) {
        return generate(user, 1);
    }

    @Override
    public Token generateForSetPassword(User user) {
        return generate(user, 2);
    }

    private Token generate(User user, int type) {
        Token token = new Token();
        token.setUser(user);
        List<Token> tokens = tokenRepository.findValidByUser(token.getUser(), type);
        if (tokens != null) {
            for (Token tk : tokens) {
                invalidateToken.invalidate(tk);
            }
        }
        token.setStatus(1);
        token.setDateTime(new Date());
        token.setType(type);

        token = tokenRepository.persist(token);
        token.setToken(jwtAdapter.generate(token.getId(), token.getUser().getId(), token.getType(), type == 1 ? Keys.getAuthKey() : Keys.getRecoveryKey()));
        token = tokenRepository.persist(token);
        token.getUser().setPassword("");
        return token;
    }
}
