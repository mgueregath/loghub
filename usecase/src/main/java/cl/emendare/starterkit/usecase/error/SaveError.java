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
            if (t == null) {
                //Logger.getAnonymousLogger().log(Level.WARNING, "{0} {1} result: {2}", new Object[]{username, methodName, result});
            } else {
                //Logger.getAnonymousLogger().log(Level.WARNING, username + " " + methodName + " result: " + result, t);
            }
            errorReporting.send();
        });
        thread.start();
    }

}
