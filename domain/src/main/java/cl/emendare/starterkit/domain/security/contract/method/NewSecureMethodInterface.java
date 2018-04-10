/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.method;

import cl.emendare.starterkit.domain.security.entity.SecureMethod;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface NewSecureMethodInterface {

    public SecureMethod add(int service, int method, String name, String detail);

}
