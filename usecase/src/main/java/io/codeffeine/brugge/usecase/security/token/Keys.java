/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.token;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class Keys {

    private static String authKey;
    private static String recoveryKey;

    static {
        authKey = "";
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("AuthenticationKey.properties"));
            authKey = config.getString("auth");
            recoveryKey = config.getString("recovery");
        } catch (ConfigurationException ex) {
            authKey = "sasdsdsadasdas";
            recoveryKey = "sasdsds22asdas";
        }
    }

    private Keys() {
        // Prevent instantation
    }

    public static String getAuthKey() {
        return authKey;
    }

    public static String getRecoveryKey() {
        return recoveryKey;
    }

}
