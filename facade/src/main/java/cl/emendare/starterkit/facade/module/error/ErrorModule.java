/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.error;

import cl.emendare.starterkit.domain.error.SaveErrorInterface;
import cl.emendare.starterkit.external.error.ErrorReporting;
import cl.emendare.starterkit.usecase.adapter.error.ErrorReportingAdapter;
import cl.emendare.starterkit.usecase.error.SaveError;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ErrorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ErrorReportingAdapter.class).to(ErrorReporting.class);
        bind(SaveErrorInterface.class).to(SaveError.class);
    }
}
