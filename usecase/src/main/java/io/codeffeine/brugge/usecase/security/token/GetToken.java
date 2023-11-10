/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.token;

import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import io.codeffeine.brugge.domain.security.contract.token.GetTokenInterface;
import io.codeffeine.brugge.domain.security.contract.user.GetUserInterface;
import io.codeffeine.brugge.domain.security.entity.Token;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.domain.security.repository.TokenRepositoryInterface;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
