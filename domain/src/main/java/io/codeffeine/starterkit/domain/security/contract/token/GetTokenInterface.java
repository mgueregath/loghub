/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.token;

import io.codeffeine.starterkit.domain.security.entity.Token;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetTokenInterface {

    public Token getById(long id);

    public List<Token> getByUser(int userId, int type);

    public List<Token> getNotValidByUser(int userId, int type);

    public List<Token> getValidByUser(int userId, int type);
}
