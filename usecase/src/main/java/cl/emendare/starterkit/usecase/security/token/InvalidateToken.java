/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.token;

import cl.emendare.exceptions.jwt.JwtInvalidationException;
import cl.emendare.starterkit.domain.security.contract.token.GetTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.InvalidateTokenInterface;
import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.repository.TokenRepositoryInterface;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
