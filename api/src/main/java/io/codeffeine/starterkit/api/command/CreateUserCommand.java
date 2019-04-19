/*
 * StarterKit.
 */
package io.codeffeine.starterkit.api.command;

import io.codeffeine.starterkit.domain.security.entity.User;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CreateUserCommand extends User {

    private String repeatedPassword;

    /**
     * @return the repeatedPassword
     */
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    /**
     * @param repeatedPassword the repeatedPassword to set
     */
    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

}
