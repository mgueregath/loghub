/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.server;

import io.codeffeine.brugge.domain.server.GetServerUsageInterface;
import io.codeffeine.brugge.usecase.server.GetServerUsage;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class UsageModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GetServerUsageInterface.class).to(GetServerUsage.class);
    }
}
