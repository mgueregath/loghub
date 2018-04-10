package cl.emendare.starterkit.facade.service;

import cl.emendare.starterkit.domain.security.contract.method.GetSecureMethodInterface;
import cl.emendare.starterkit.domain.security.entity.SecureMethod;
import cl.emendare.starterkit.domain.security.entity.Service;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.permission.ServiceIdentification;
import cl.emendare.starterkit.facade.permission.annotation.Permission;
import cl.emendare.starterkit.facade.permission.annotation.ProtectedService;
import com.google.inject.Inject;
import java.util.List;

/*
 * StarterKit.
 */
/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
