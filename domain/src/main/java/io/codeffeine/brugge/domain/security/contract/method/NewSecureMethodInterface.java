/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.contract.method;

import io.codeffeine.brugge.domain.security.entity.SecureMethod;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface NewSecureMethodInterface {

    public SecureMethod add(int service, int method, String name, String detail);

}
