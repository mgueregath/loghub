/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.security;

import io.codeffeine.brugge.domain.security.contract.token.GenerateTokenInterface;
import io.codeffeine.brugge.domain.security.contract.token.GetTokenInterface;
import io.codeffeine.brugge.domain.security.contract.token.InvalidateTokenInterface;
import io.codeffeine.brugge.domain.security.contract.token.ValidateTokenInterface;
import io.codeffeine.brugge.domain.security.repository.TokenRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.repository.TokenRepository;
import io.codeffeine.brugge.usecase.security.token.GenerateToken;
import io.codeffeine.brugge.usecase.security.token.GetToken;
import io.codeffeine.brugge.usecase.security.token.InvalidateToken;
import io.codeffeine.brugge.usecase.security.token.ValidateToken;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
