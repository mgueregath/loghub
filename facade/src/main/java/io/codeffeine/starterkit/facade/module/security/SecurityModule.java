/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.security;

import io.codeffeine.starterkit.domain.security.repository.SecureMethodRepositoryInterface;
import io.codeffeine.starterkit.domain.security.contract.method.GetSecureMethodInterface;
import io.codeffeine.starterkit.domain.security.contract.method.NewSecureMethodInterface;
import io.codeffeine.starterkit.facade.permission.ServiceRegister;
import io.codeffeine.starterkit.persistence.postgresql.repository.SecureMethodRepository;
import io.codeffeine.starterkit.usecase.security.method.GetSecureMethod;
import io.codeffeine.starterkit.usecase.security.method.NewSecureMethod;
import io.codeffeine.starterkit.usecase.keeper.PermissionsKeeper;
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
