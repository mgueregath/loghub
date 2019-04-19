/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.error;

import cl.emendare.starterkit.domain.error.SaveErrorInterface;
import cl.emendare.starterkit.usecase.adapter.error.ErrorReportingAdapter;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class SaveError implements SaveErrorInterface {

    private final ErrorReportingAdapter errorReporting;

    @Inject
    public SaveError(ErrorReportingAdapter errorReporting) {
        this.errorReporting = errorReporting;
    }

    @Override
    public void save(String username, boolean result, String methodName, Throwable t) {
        Thread thread = new Thread(() -> {

            errorReporting.send();
        });
        thread.start();
    }

    @Override
    public void save(String username, boolean result, String methodName) {
        Thread thread = new Thread(() -> {

            errorReporting.send();
        });
        thread.start();
    }

}
