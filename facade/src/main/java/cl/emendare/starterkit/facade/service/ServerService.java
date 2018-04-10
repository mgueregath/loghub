/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.service;

import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.server.GetServerUsageInterface;
import cl.emendare.starterkit.facade.permission.ServiceIdentification;
import cl.emendare.starterkit.facade.permission.annotation.Permission;
import cl.emendare.starterkit.facade.permission.annotation.ProtectedService;
import com.google.inject.Inject;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
