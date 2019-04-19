/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.user;

import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import io.codeffeine.starterkit.domain.security.contract.user.GetUserInterface;
import io.codeffeine.starterkit.domain.security.entity.User;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
