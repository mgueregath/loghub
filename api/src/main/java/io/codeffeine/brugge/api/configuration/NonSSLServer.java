/*
 * Emendare product for an specific client.
 */
package io.codeffeine.brugge.api.configuration;

import io.codeffeine.brugge.api.props.ApplicationProps;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Configuration
public class NonSSLServer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Autowired
    private ApplicationProps applicationProps;

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(applicationProps.getNonSslPort() != 0 ? applicationProps.getNonSslPort() : 8080);
        factory.addAdditionalTomcatConnectors(connector);
    }

}
