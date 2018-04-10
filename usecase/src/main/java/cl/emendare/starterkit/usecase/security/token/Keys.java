/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.token;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class Keys {

    private static String authKey;

    static {
        authKey = "";
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("AuthenticationKey.properties"));
            authKey = config.getString("auth");
        } catch (ConfigurationException ex) {
            authKey = "sasdsdsadasdas";
        }
    }

    private Keys() {
        // Prevent instantation
    }

    public static String getAuthKey() {
        return authKey;
    }

}
