/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.container;

import cl.emendare.starterkit.facade.migration.MigrationExecutor;
import cl.emendare.starterkit.facade.module.adapter.AdapterModule;
import cl.emendare.starterkit.facade.module.aspect.AspectModule;
import cl.emendare.starterkit.facade.module.error.ErrorModule;
import cl.emendare.starterkit.facade.module.mailing.MailingModule;
import cl.emendare.starterkit.facade.module.migration.MigrationModule;
import cl.emendare.starterkit.facade.module.persistence.PersistenceModule;
import cl.emendare.starterkit.facade.module.security.RoleModule;
import cl.emendare.starterkit.facade.module.security.SecurityModule;
import cl.emendare.starterkit.facade.module.security.TokenModule;
import cl.emendare.starterkit.facade.module.security.UserModule;
import cl.emendare.starterkit.facade.module.server.UsageModule;
import cl.emendare.starterkit.facade.permission.ServiceRegister;
import cl.emendare.starterkit.facade.service.AuthenticationService;
import cl.emendare.starterkit.facade.service.RoleService;
import cl.emendare.starterkit.facade.service.ServerService;
import cl.emendare.starterkit.facade.service.Services;
import cl.emendare.starterkit.facade.service.UserService;
import cl.emendare.starterkit.persistence.postgresql.PostgreSQLSession;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class ServiceContainer {

    private final Injector injector;

    public ServiceContainer() {
        injector = Guice.createInjector(
                new AdapterModule(),
                new PersistenceModule(),
                new SecurityModule(),
                new AspectModule(),
                new MigrationModule(),
                new RoleModule(),
                new TokenModule(),
                new UserModule(),
                new MailingModule(),
                new UsageModule(),
                new ErrorModule()
        );
        onStart();
    }

    private void onStart() {
        injector.getInstance(PostgreSQLSession.class);
        injector.getInstance(MigrationExecutor.class).execute();
        injector.getInstance(ServiceRegister.class).registerServices();
    }

    public void onDestroy() {
        injector.getInstance(PostgreSQLSession.class).stop();
    }

    public Services getServices() {
        return injector.getInstance(Services.class);
    }

    public ServerService getServerService() {
        return injector.getInstance(ServerService.class);
    }

    public AuthenticationService getAuthenticationService() {
        return injector.getInstance(AuthenticationService.class);
    }

    public RoleService getRoleService() {
        return injector.getInstance(RoleService.class);
    }

    public UserService getUserService() {
        return injector.getInstance(UserService.class);
    }
}
