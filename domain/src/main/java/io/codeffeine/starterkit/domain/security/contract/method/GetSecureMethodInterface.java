/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.contract.method;

import io.codeffeine.starterkit.domain.security.entity.SecureMethod;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetSecureMethodInterface {

    public List<SecureMethod> getAll();

    public List<SecureMethod> getByService(int service);

    public SecureMethod getByServiceAndMethod(int service, int methodId);

    //public SecureMethod getById(int id);
}
