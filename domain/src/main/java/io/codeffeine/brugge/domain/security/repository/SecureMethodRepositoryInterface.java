/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.security.repository;

import io.codeffeine.brugge.domain.security.entity.SecureMethod;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface SecureMethodRepositoryInterface {

    public List<SecureMethod> findAll();

    public List<SecureMethod> findByService(int service);

    public SecureMethod findByServiceAndMethod(int service, int methodId);

    public SecureMethod findById(int id);

    public SecureMethod persist(SecureMethod method);

    public List<SecureMethod> persist(List<SecureMethod> methods);

    public boolean remove(SecureMethod method);
}
