/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.token;

import io.codeffeine.brugge.domain.security.contract.token.GetTokenInterface;
import io.codeffeine.brugge.domain.security.contract.token.InvalidateTokenInterface;
import io.codeffeine.brugge.domain.security.entity.Token;
import io.codeffeine.brugge.domain.security.repository.TokenRepositoryInterface;
import io.codeffeine.brugge.usecase.exception.jwt.JwtInvalidationException;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class InvalidateToken implements InvalidateTokenInterface {

    private final TokenRepositoryInterface tokenRepository;
    private final GetTokenInterface getToken;

    @Inject
    public InvalidateToken(
            TokenRepositoryInterface tokenRepository,
            GetTokenInterface getToken
    ) {
        this.tokenRepository = tokenRepository;
        this.getToken = getToken;
    }

    @Override
    public boolean invalidate(Token token) {
        token = getToken.getById(token.getId());
        token.setStatus(2);
        token = tokenRepository.persist(token);
        if (token.getStatus() != 2) {
            throw new JwtInvalidationException();
        }
        return true;
    }
}
