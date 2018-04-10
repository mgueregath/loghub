/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.method;

import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.repository.SecureMethodRepositoryInterface;
import cl.emendare.starterkit.domain.security.contract.method.GetSecureMethodInterface;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetSecureMethod implements GetSecureMethodInterface {

    private SecureMethodRepositoryInterface repository;

    @Inject
    public GetSecureMethod(
            SecureMethodRepositoryInterface repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<SecureMethod> getAll() {
        List<SecureMethod> methods = repository.findAll();
        if (methods == null) {
            throw new DataNotFoundException();
        }
        return methods;
    }

    @Override
    public List<SecureMethod> getByService(int service) {
        List<SecureMethod> methods = repository.findByService(service);
        if (methods == null) {
            throw new DataNotFoundException();
        }
        return methods;
    }

    @Override
    public SecureMethod getByServiceAndMethod(int service, int methodId) {
        SecureMethod method = repository.findByServiceAndMethod(service, methodId);
        if (method == null) {
            throw new DataNotFoundException();
        }
        return method;
    }
    /*
    @Override
    public SecureMethod getById(int id) {
        SecureMethod method = repository.findById(id);
        if (method == null) {
            throw new DataNotFoundException();
        }
        return method;
    }
     */
}
