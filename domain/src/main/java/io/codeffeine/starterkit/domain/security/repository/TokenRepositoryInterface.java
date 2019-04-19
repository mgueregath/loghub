/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.repository;

import io.codeffeine.starterkit.domain.security.entity.Token;
import io.codeffeine.starterkit.domain.security.entity.User;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface TokenRepositoryInterface {

    public Token findById(long id);

    public List<Token> findByUser(User user, int type);

    public List<Token> findValidByUser(User user, int type);

    public List<Token> findNotValidByUser(User user, int type);

    public Token persist(Token token);
}
