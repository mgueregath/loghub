/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.permission;

import cl.emendare.exceptions.data.DataNotFoundException;
import cl.emendare.starterkit.domain.security.entity.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ServiceIdentification {

    public static final int SERVICES = 1;
    public static final int AUTH = 2;
    public static final int COMMONS = 3;
    public static final int PERMISSIONS = 4;
    public static final int ROLES = 5;
    public static final int USERS = 6;
    public static final int SERVER = 7;

    private static final List<Service> services;

    static {
        services = new ArrayList<>();
        services.add(new Service(SERVICES, "Servicios"));
        services.add(new Service(AUTH, "Autenticación"));
        services.add(new Service(COMMONS, "Comunes"));
        services.add(new Service(PERMISSIONS, "Permisos"));
        services.add(new Service(ROLES, "Roles"));
        services.add(new Service(USERS, "Usuarios"));
        services.add(new Service(SERVER, "Servidor"));
    }

    private ServiceIdentification() {
        // Prevent instantiation
    }

    public static List<Service> getServices() {
        return services;
    }

    public static Service getService(int id) {
        for (Service service : services) {
            if (service.getId() == id) {
                return service;
            }
        }
        throw new DataNotFoundException();
    }

    public static int getMaxService() {
        int maxKey = 0;
        for (Service service : services) {
            if (service.getId() > maxKey) {
                maxKey = service.getId();
            }
        }
        return maxKey;
    }
}
