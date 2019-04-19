/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.service;

import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.domain.server.GetServerUsageInterface;
import io.codeffeine.starterkit.facade.permission.ServiceIdentification;
import io.codeffeine.starterkit.facade.permission.annotation.Permission;
import io.codeffeine.starterkit.facade.permission.annotation.ProtectedService;
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
