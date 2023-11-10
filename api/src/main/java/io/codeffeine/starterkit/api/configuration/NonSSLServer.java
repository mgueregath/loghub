/*
 * Emendare product for an specific client.
 */
package io.codeffeine.starterkit.api.configuration;

import io.codeffeine.starterkit.api.props.ApplicationProps;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Configuration
public class NonSSLServer {

    @Autowired
    private ApplicationProps applicationProps;

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    TomcatEmbeddedServletContainerFactory containerFactory
                            = (TomcatEmbeddedServletContainerFactory) container;

                    Connector connector = new Connector(TomcatEmbeddedServletContainerFactory.DEFAULT_PROTOCOL);
                    connector.setPort(applicationProps.getNonSslPort() != 0 ? applicationProps.getNonSslPort() : 8080);
                    containerFactory.addAdditionalTomcatConnectors(connector);
                }
            }
        };
    }
}
