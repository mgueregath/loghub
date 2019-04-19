/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.error;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface SaveErrorInterface {

    public void save(String username, boolean result, String methodName, Throwable t);

    public void save(String username, boolean result, String methodName);
}
