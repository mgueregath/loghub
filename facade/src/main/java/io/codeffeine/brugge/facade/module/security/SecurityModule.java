/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.security;

import io.codeffeine.brugge.domain.security.repository.SecureMethodRepositoryInterface;
import io.codeffeine.brugge.domain.security.contract.method.GetSecureMethodInterface;
import io.codeffeine.brugge.domain.security.contract.method.NewSecureMethodInterface;
import io.codeffeine.brugge.facade.permission.ServiceRegister;
import io.codeffeine.brugge.persistence.postgresql.repository.SecureMethodRepository;
import io.codeffeine.brugge.usecase.security.method.GetSecureMethod;
import io.codeffeine.brugge.usecase.security.method.NewSecureMethod;
import io.codeffeine.brugge.usecase.keeper.PermissionsKeeper;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class SecurityModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PermissionsKeeper.class).in(Singleton.class);
        bind(SecureMethodRepositoryInterface.class).to(SecureMethodRepository.class);
        bind(GetSecureMethodInterface.class).to(GetSecureMethod.class);
        bind(NewSecureMethodInterface.class).to(NewSecureMethod.class);
        requestInjection(ServiceRegister.class);
    }
}
