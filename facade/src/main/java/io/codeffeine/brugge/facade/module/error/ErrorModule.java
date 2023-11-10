/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.error;

import io.codeffeine.brugge.domain.error.SaveErrorInterface;
import io.codeffeine.brugge.external.error.ErrorReporting;
import io.codeffeine.brugge.usecase.adapter.error.ErrorReportingAdapter;
import io.codeffeine.brugge.usecase.error.SaveError;
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
