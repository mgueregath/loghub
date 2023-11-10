/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.error;

import io.codeffeine.brugge.domain.error.SaveErrorInterface;
import io.codeffeine.brugge.usecase.adapter.error.ErrorReportingAdapter;
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
