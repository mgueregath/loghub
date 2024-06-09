/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.permission;

import io.codeffeine.brugge.domain.security.entity.Service;
import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ServiceIdentification {

    public static final int SERVICES = 1;
    public static final int AUTH = 2;
    public static final int COMMONS = 3;
    public static final int PERMISSIONS = 4;
    public static final int ROLES = 5;
    public static final int USERS = 6;
    public static final int SERVER = 7;
    public static final int LOGS = 8;

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
        services.add(new Service(LOGS, "Logs"));
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
