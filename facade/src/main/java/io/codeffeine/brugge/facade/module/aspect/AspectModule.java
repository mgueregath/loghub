/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.aspect;

import io.codeffeine.brugge.facade.permission.interceptor.PermissionInterceptor;
import com.google.inject.AbstractModule;
import static org.aspectj.lang.Aspects.aspectOf;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class AspectModule extends AbstractModule {

    @Override
    protected void configure() {
        requestInjection(aspectOf(PermissionInterceptor.class));
    }
}
