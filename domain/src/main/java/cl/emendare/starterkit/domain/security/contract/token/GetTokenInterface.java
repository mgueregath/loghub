/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.token;

import cl.emendare.starterkit.domain.security.entity.Token;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetTokenInterface {

    public Token getById(long id);

    public List<Token> getByUser(int userId, int type);

    public List<Token> getNotValidByUser(int userId, int type);

    public List<Token> getValidByUser(int userId, int type);
}
