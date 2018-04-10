package cl.emendare.starterkit.api;

import cl.emendare.starterkit.api.adapter.response.CustomResponse;
import cl.emendare.starterkit.api.adapter.response.ResponseAdapter;
import cl.emendare.starterkit.facade.container.ServiceContainer;
import java.io.IOException;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/*
 * StarterKit.
 */
/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@SpringBootApplication
@EnableAutoConfiguration()
@EnableJSONDoc
public class RestApi extends SpringBootServletInitializer {

    private static ConfigurableApplicationContext ctx;

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
        return new ServiceContainer();
    }
}
