/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.error;

import io.codeffeine.starterkit.domain.error.SaveErrorInterface;
import io.codeffeine.starterkit.external.error.ErrorReporting;
import io.codeffeine.starterkit.usecase.adapter.error.ErrorReportingAdapter;
import io.codeffeine.starterkit.usecase.error.SaveError;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ErrorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ErrorReportingAdapter.class).to(ErrorReporting.class);
        bind(SaveErrorInterface.class).to(SaveError.class);
    }
}
