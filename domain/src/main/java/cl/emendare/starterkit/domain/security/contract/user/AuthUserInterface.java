/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.user;

import cl.emendare.starterkit.domain.security.entity.Token;
import cl.emendare.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface AuthUserInterface {

    public Token login(String username, String password);

    public boolean logout(User user);
}
