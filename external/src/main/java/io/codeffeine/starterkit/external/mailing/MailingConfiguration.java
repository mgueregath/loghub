/*
 * StarterKit.
 */
package io.codeffeine.starterkit.external.mailing;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MailingConfiguration {

    private String emailAddress = null;
    private String secret = null;
    private int port = 465;
    private String server = null;
    private String name = null;
    private Boolean testing = true;
    private Boolean defaultValues = true;

    public MailingConfiguration() {
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("email.properties"));
            emailAddress = config.getString("emailAddress");
            secret = config.getString("password");
            port = config.getInt("port");
            server = config.getString("server");
            name = config.getString("name");
            testing = config.getBoolean("testing");
        } catch (ConfigurationException ex) {
            // No action
        }
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the testing
     */
    public boolean isTesting() {
        return testing;
    }

    /**
     * @param testing the testing to set
     */
    public void setTesting(boolean testing) {
        this.testing = testing;
    }

    /**
     * @return the defaultValues
     */
    public Boolean getDefaultValues() {
        return defaultValues;
    }

    /**
     * @param defaultValues the defaultValues to set
     */
    public void setDefaultValues(Boolean defaultValues) {
        this.defaultValues = defaultValues;
    }
}
