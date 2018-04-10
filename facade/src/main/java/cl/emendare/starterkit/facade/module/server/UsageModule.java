/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.server;

import cl.emendare.starterkit.domain.server.GetServerUsageInterface;
import cl.emendare.starterkit.usecase.server.GetServerUsage;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class UsageModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GetServerUsageInterface.class).to(GetServerUsage.class);
    }
}
