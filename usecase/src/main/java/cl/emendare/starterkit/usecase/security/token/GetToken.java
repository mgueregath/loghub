/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.token;

import cl.emendare.starterkit.usecase.exception.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.contract.token.GetTokenInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.repository.TokenRepositoryInterface;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetToken implements GetTokenInterface {

    private final TokenRepositoryInterface tokenRepository;
    private final GetUserInterface getUser;

    @Inject
    public GetToken(
            TokenRepositoryInterface tokenRepository,
            GetUserInterface getUser
    ) {
        this.tokenRepository = tokenRepository;
        this.getUser = getUser;
    }

    @Override
    public Token getById(long id) {
        Token token = tokenRepository.findById(id);
        if (token == null) {
            throw new DataNotFoundException();
        }
        return token;
    }

    @Override
    public List<Token> getByUser(int userId, int type) {
        User user = getUser.getById(userId);
        return tokenRepository.findByUser(user, type);
    }

    @Override
    public List<Token> getNotValidByUser(int userId, int type) {
        User user = getUser.getById(userId);
        return tokenRepository.findNotValidByUser(user, type);
    }

    @Override
    public List<Token> getValidByUser(int userId, int type) {
        User user = getUser.getById(userId);
        return tokenRepository.findValidByUser(user, type);
    }
}
