package io.codeffeine.brugge.api;

import io.codeffeine.brugge.api.adapter.response.CustomResponse;
import io.codeffeine.brugge.api.adapter.response.ResponseAdapter;
import io.codeffeine.brugge.api.props.ApplicationProps;
import io.codeffeine.brugge.facade.container.ServiceContainer;
import java.io.IOException;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/*
 * Brugge Framework.
 */
/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
@SpringBootApplication
@EnableJSONDoc
@EnableConfigurationProperties(value = ApplicationProps.class)
public class RestApi extends SpringBootServletInitializer {

    private static ConfigurableApplicationContext ctx;

    @Autowired
    private ApplicationProps applicationProps;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApi.class);
    }

    public static void main(String[] args) throws IOException {
        ctx = SpringApplication.run(RestApi.class, args);
    }

    @Bean
    public ResponseAdapter getCustomResponse() {
        return new CustomResponse();
    }

    @Bean(destroyMethod = "onDestroy")
    public ServiceContainer sc() throws Exception {
        return new ServiceContainer(applicationProps.getEnvironment());
    }
}
