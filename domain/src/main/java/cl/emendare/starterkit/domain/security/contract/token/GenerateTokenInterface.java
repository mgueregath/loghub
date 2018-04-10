/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.token;

import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GenerateTokenInterface {

    public Token generateForAuth(User user);

    public Token generateForSetPassword(User user);
}
