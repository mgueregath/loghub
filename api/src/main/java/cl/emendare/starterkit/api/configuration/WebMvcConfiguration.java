/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.configuration;

import cl.emendare.starterkit.api.interceptor.CorsInterceptor;
import cl.emendare.starterkit.api.interceptor.OAuth2Interceptor;
import cl.emendare.starterkit.api.interceptor.TokenInterceptor;
import cl.emendare.starterkit.facade.container.ServiceContainer;
import cl.emendare.starterkit.persistence.storage.StoragePath;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private ServiceContainer sc;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new TokenInterceptor(sc))
                .addPathPatterns(PathConfiguration.API_PATH + "/**")
                .addPathPatterns("/auth/**");

        registry.addInterceptor(new CorsInterceptor())
                .addPathPatterns("/jsondoc/**")
                .addPathPatterns("/");

        registry.addInterceptor(new OAuth2Interceptor())
                .addPathPatterns("/server/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + StoragePath.BASE_PATH + "/");

        registry.addResourceHandler("/documents/**")
                .addResourceLocations("file:" + StoragePath.BASE_PATH + "/");

        super.addResourceHandlers(registry);

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }

    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new Hibernate5Module());

        messageConverter.setObjectMapper(mapper);
        return messageConverter;

    }
}
