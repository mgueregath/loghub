/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.service;

import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.domain.server.GetServerUsageInterface;
import io.codeffeine.brugge.facade.permission.ServiceIdentification;
import io.codeffeine.brugge.facade.permission.annotation.Permission;
import io.codeffeine.brugge.facade.permission.annotation.ProtectedService;
import com.google.inject.Inject;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
@ProtectedService(
        service = ServiceIdentification.SERVER
)
public class ServerService {

    private final GetServerUsageInterface getServerUsage;

    @Inject
    public ServerService(GetServerUsageInterface getServerUsage) {
        this.getServerUsage = getServerUsage;
    }

    @Permission(
            details = "Obtener el uso del servidor",
            method = 1
    )
    public Map<String, Object> getServerUsage(User user) {
        return getServerUsage.getUsage();
    }
}
