/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.aspect;

import cl.emendare.starterkit.facade.permission.interceptor.PermissionInterceptor;
import com.google.inject.AbstractModule;
import static org.aspectj.lang.Aspects.aspectOf;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class AspectModule extends AbstractModule {

    @Override
    protected void configure() {
        requestInjection(aspectOf(PermissionInterceptor.class));
    }
}
