/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.security.method;

import io.codeffeine.starterkit.usecase.exception.data.DataNotFoundException;
import io.codeffeine.starterkit.domain.security.repository.SecureMethodRepositoryInterface;
import io.codeffeine.starterkit.domain.security.contract.method.GetSecureMethodInterface;
import io.codeffeine.starterkit.domain.security.contract.method.NewSecureMethodInterface;
import io.codeffeine.starterkit.domain.security.entity.Method;
import io.codeffeine.starterkit.domain.security.entity.SecureMethod;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class NewSecureMethod implements NewSecureMethodInterface {

    private final SecureMethodRepositoryInterface repository;
    private final GetSecureMethodInterface getSecureMethod;

    @Inject
    public NewSecureMethod(
            SecureMethodRepositoryInterface repository,
            GetSecureMethodInterface getSecureMethod
    ) {
        this.repository = repository;
        this.getSecureMethod = getSecureMethod;
    }

    @Override
    public SecureMethod add(int service, int methodId, String name, String detail) {
        SecureMethod secureMethod = null;
        try {
            secureMethod = getSecureMethod.getByServiceAndMethod(service, methodId);
        } catch (DataNotFoundException e) {
            // No action
        }
        if (secureMethod != null) {
            if (!secureMethod.getName().equals(name)) {
                secureMethod.setName(name);
            }
            if (!secureMethod.getDetail().equals(detail)) {
                secureMethod.setDetail(detail);
            }
        } else {
            Method method = new Method(service, methodId);
            secureMethod = new SecureMethod(name, detail, method);
        }
        return repository.persist(secureMethod);
    }
}
