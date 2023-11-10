/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.container;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.codeffeine.starterkit.facade.environment.Environment;
import io.codeffeine.starterkit.facade.migration.MigrationExecutor;
import io.codeffeine.starterkit.facade.module.adapter.AdapterModule;
import io.codeffeine.starterkit.facade.module.aspect.AspectModule;
import io.codeffeine.starterkit.facade.module.environment.EnvironmentModule;
import io.codeffeine.starterkit.facade.module.error.ErrorModule;
import io.codeffeine.starterkit.facade.module.mailing.MailingModule;
import io.codeffeine.starterkit.facade.module.migration.MigrationModule;
import io.codeffeine.starterkit.facade.module.notification.NotificationModule;
import io.codeffeine.starterkit.facade.module.persistence.PersistenceModule;
import io.codeffeine.starterkit.facade.module.security.RoleModule;
import io.codeffeine.starterkit.facade.module.security.SecurityModule;
import io.codeffeine.starterkit.facade.module.security.TokenModule;
import io.codeffeine.starterkit.facade.module.security.UserModule;
import io.codeffeine.starterkit.facade.module.server.UsageModule;
import io.codeffeine.starterkit.facade.permission.ServiceRegister;
import io.codeffeine.starterkit.facade.service.AuthenticationService;
import io.codeffeine.starterkit.facade.service.RoleService;
import io.codeffeine.starterkit.facade.service.ServerService;
import io.codeffeine.starterkit.facade.service.Services;
import io.codeffeine.starterkit.facade.service.UserService;
import io.codeffeine.starterkit.persistence.postgresql.PostgreSQLSession;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ServiceContainer {

    private final Injector injector;
    private final Environment environment;

    public ServiceContainer(Environment environment) {

        this.environment = environment;

        injector = Guice.createInjector(
                new EnvironmentModule(environment),
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
                new ErrorModule(),
                new NotificationModule()
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
