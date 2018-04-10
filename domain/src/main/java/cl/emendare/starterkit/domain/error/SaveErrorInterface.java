/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.error;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface SaveErrorInterface {

    public void save(String username, boolean result, String methodName, Throwable t);
}
