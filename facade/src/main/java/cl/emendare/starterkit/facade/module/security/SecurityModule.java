/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.security;

import cl.emendare.starterkit.domain.security.repository.SecureMethodRepositoryInterface;
import cl.emendare.starterkit.domain.security.contract.method.GetSecureMethodInterface;
import cl.emendare.starterkit.domain.security.contract.method.NewSecureMethodInterface;
import cl.emendare.starterkit.facade.permission.ServiceRegister;
import cl.emendare.starterkit.persistence.postgresql.repository.SecureMethodRepository;
import cl.emendare.starterkit.usecase.security.method.GetSecureMethod;
import cl.emendare.starterkit.usecase.security.method.NewSecureMethod;
import cl.emendare.starterkit.usecase.keeper.PermissionsKeeper;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
