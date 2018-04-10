/*
 * StarterKit.
 */
package cl.emendare.starterkit.external.mailing;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class MailingConfiguration {

    public static String emailAddress = null;
    public static String secret = null;
    public static int port = 465;
    public static String server = null;
    public static String name = null;

    static {
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("mailing.properties"));
            emailAddress = config.getString("emailAddress");
            secret = config.getString("password");
            port = config.getInt("port");
            server = config.getString("server");
            name = config.getString("name");
        } catch (ConfigurationException ex) {
        }
    }

    private MailingConfiguration() {
        // Prevent instantation
    }
}
