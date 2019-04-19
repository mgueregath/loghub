/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.server;

import io.codeffeine.starterkit.domain.server.GetServerUsageInterface;
import io.codeffeine.starterkit.usecase.server.GetServerUsage;
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
