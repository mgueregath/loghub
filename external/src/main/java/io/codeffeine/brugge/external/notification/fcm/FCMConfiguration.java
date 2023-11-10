/*
 * Tasty.
 */
package io.codeffeine.brugge.external.notification.fcm;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class FCMConfiguration {

    public static String CREDENTIAL = null;
    public static String URL = null;
    public static boolean ENABLED = false;

    static {
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("fcm.properties"));
            CREDENTIAL = config.getString("credential");
            URL = config.getString("url");
            ENABLED = config.getBoolean("enabled");
        } catch (ConfigurationException ex) {
        }
    }

    private FCMConfiguration() {
        // Prevent instantation
    }
}
