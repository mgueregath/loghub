/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.error;

import io.codeffeine.starterkit.domain.error.SaveErrorInterface;
import io.codeffeine.starterkit.usecase.adapter.error.ErrorReportingAdapter;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
