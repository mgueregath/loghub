/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.api.configuration;

import io.codeffeine.brugge.api.interceptor.CorsInterceptor;
import io.codeffeine.brugge.api.interceptor.OAuth2Interceptor;
import io.codeffeine.brugge.api.interceptor.TokenInterceptor;
import io.codeffeine.brugge.facade.container.ServiceContainer;
import io.codeffeine.brugge.persistence.storage.StoragePath;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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

        String[] locations = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"};

        registry.addResourceHandler("/assets/**")
                .addResourceLocations(locations);

        registry.addResourceHandler("/documents/**")
                .addResourceLocations("file:" + StoragePath.BASE_PATH + "/");

        super.addResourceHandlers(registry);

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        MediaType mediaType = new MediaType("application", "x-www-form-urlencoded", Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(mediaType));
        converters.add(converter);
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
