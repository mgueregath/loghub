/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.token;

import cl.emendare.starterkit.domain.security.contract.token.GenerateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.InvalidateTokenInterface;
import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.repository.TokenRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.jwt.JwtAdapter;
import com.google.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
        token.setToken(jwtAdapter.generate(token.getId(), token.getUser().getId(), token.getType(), Keys.getAuthKey()));
        token = tokenRepository.persist(token);
        token.getUser().setPassword("");
        return token;
    }
}
