package io.codeffeine.brugge.facade.service;

import io.codeffeine.brugge.domain.security.contract.method.GetSecureMethodInterface;
import io.codeffeine.brugge.domain.security.entity.SecureMethod;
import io.codeffeine.brugge.domain.security.entity.Service;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.facade.permission.ServiceIdentification;
import io.codeffeine.brugge.facade.permission.annotation.Permission;
import io.codeffeine.brugge.facade.permission.annotation.ProtectedService;
import com.google.inject.Inject;
import java.util.List;

/*
 * Brugge Framework.
 */
/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
@ProtectedService(
        service = ServiceIdentification.SERVICES
)
public class Services {

    private final GetSecureMethodInterface getSecureMethod;

    @Inject
    public Services(GetSecureMethodInterface getSecureMethod) {
        this.getSecureMethod = getSecureMethod;
    }

    @Permission(
            details = "Obtener los servicios",
            method = 1
    )
    public List<Service> getServices(User user) {
        return ServiceIdentification.getServices();
    }

    @Permission(
            details = "Obtener un servicio por id",
            method = 2
    )
    public Service getService(User user, int service) {
        return ServiceIdentification.getService(service);
    }

    @Permission(
            details = "Ver todos los métodos protegidos",
            method = 3
    )
    public List<SecureMethod> getSecureMethods(User user) {
        return getSecureMethod.getAll();
    }

    @Permission(
            details = "Ver todos los métodos protegidos para un servicio",
            method = 4
    )
    public List<SecureMethod> getSecureMethodsByService(User user, int service) {
        return getSecureMethod.getByService(service);
    }

    @Permission(
            details = "Ver un método protegido",
            method = 5
    )
    public SecureMethod getSecureMethodById(User user, int service, int method) {
        return getSecureMethod.getByServiceAndMethod(service, method);
    }

}
