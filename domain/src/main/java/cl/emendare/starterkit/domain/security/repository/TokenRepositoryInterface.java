/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.repository;

import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface TokenRepositoryInterface {

    public Token findById(long id);

    public List<Token> findByUser(User user, int type);

    public List<Token> findValidByUser(User user, int type);

    public List<Token> findNotValidByUser(User user, int type);

    public Token persist(Token token);
}
