/*
 * Emendare product for an specific client.
 */
package io.codeffeine.brugge.api.props;

import io.codeffeine.brugge.facade.environment.Environment;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Component
@ConfigurationProperties(prefix = "configurations")
public class ApplicationProps {

    private Environment environment;
    private int nonSslPort;

    /**
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * @param environment the environment to set
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * @return the nonSslPort
     */
    public int getNonSslPort() {
        return nonSslPort;
    }

    /**
     * @param nonSslPort the nonSslPort to set
     */
    public void setNonSslPort(int nonSslPort) {
        this.nonSslPort = nonSslPort;
    }
}
