/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.security;

import cl.emendare.starterkit.domain.security.contract.token.GenerateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.GetTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.InvalidateTokenInterface;
import cl.emendare.starterkit.domain.security.contract.token.ValidateTokenInterface;
import cl.emendare.starterkit.domain.security.repository.TokenRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.repository.TokenRepository;
import cl.emendare.starterkit.usecase.security.token.GenerateToken;
import cl.emendare.starterkit.usecase.security.token.GetToken;
import cl.emendare.starterkit.usecase.security.token.InvalidateToken;
import cl.emendare.starterkit.usecase.security.token.ValidateToken;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class TokenModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TokenRepositoryInterface.class).to(TokenRepository.class);
        bind(ValidateTokenInterface.class).to(ValidateToken.class);
        bind(GetTokenInterface.class).to(GetToken.class);
        bind(InvalidateTokenInterface.class).to(InvalidateToken.class);
        bind(GenerateTokenInterface.class).to(GenerateToken.class);
    }
}
