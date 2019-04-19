/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.method;

import io.codeffeine.starterkit.domain.security.entity.SecureMethod;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewSecureMethodInterface {

    public SecureMethod add(int service, int method, String name, String detail);

}
