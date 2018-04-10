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
public interface ValidateTokenInterface {

    public User validateForAuth(String token);

    public User validateForSetPassword(String token);

    public Token getToken(String token, int type);
}
