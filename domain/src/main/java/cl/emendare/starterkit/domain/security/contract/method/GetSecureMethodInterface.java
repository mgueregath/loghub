/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.contract.method;

import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface GetSecureMethodInterface {

    public List<SecureMethod> getAll();

    public List<SecureMethod> getByService(int service);

    public SecureMethod getByServiceAndMethod(int service, int methodId);

    //public SecureMethod getById(int id);
}
