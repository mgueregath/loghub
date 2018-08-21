/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.starterkit.usecase.exception.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.entity.User;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class CheckIfUserExist implements CheckIfUserExistInterface {

    private final GetUserInterface getUser;

    @Inject
    public CheckIfUserExist(
            GetUserInterface getUser
    ) {
        this.getUser = getUser;
    }

    @Override
    public boolean checkByUsername(String username) {
        try {
            User user = getUser.getByUsername(username);
            return true;
        } catch (DataNotFoundException ex) {
            return false;
        }
    }
}
