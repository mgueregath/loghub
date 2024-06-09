/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.container;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.codeffeine.brugge.facade.environment.Environment;
import io.codeffeine.brugge.facade.migration.MigrationExecutor;
import io.codeffeine.brugge.facade.module.adapter.AdapterModule;
import io.codeffeine.brugge.facade.module.aspect.AspectModule;
import io.codeffeine.brugge.facade.module.environment.EnvironmentModule;
import io.codeffeine.brugge.facade.module.error.ErrorModule;
import io.codeffeine.brugge.facade.module.logic.LogModule;
import io.codeffeine.brugge.facade.module.mailing.MailingModule;
import io.codeffeine.brugge.facade.module.migration.MigrationModule;
import io.codeffeine.brugge.facade.module.notification.NotificationModule;
import io.codeffeine.brugge.facade.module.persistence.PersistenceModule;
import io.codeffeine.brugge.facade.module.security.RoleModule;
import io.codeffeine.brugge.facade.module.security.SecurityModule;
import io.codeffeine.brugge.facade.module.security.TokenModule;
import io.codeffeine.brugge.facade.module.security.UserModule;
import io.codeffeine.brugge.facade.module.server.UsageModule;
import io.codeffeine.brugge.facade.permission.ServiceRegister;
import io.codeffeine.brugge.facade.service.AuthenticationService;
import io.codeffeine.brugge.facade.service.LogService;
import io.codeffeine.brugge.facade.service.RoleService;
import io.codeffeine.brugge.facade.service.ServerService;
import io.codeffeine.brugge.facade.service.Services;
import io.codeffeine.brugge.facade.service.UserService;
import io.codeffeine.brugge.persistence.elastic.ElasticSession;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;

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
                new NotificationModule(),
                new LogModule()
        );
        onStart();
    }

    private void onStart() {
        injector.getInstance(PostgreSQLSession.class);
        injector.getInstance(MigrationExecutor.class).execute();
        injector.getInstance(ServiceRegister.class).registerServices();
        injector.getInstance(ElasticSession.class);
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

    public LogService getLogService() {
        return injector.getInstance(LogService.class);
    }
}
