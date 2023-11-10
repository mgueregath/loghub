/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.facade.module.security;

import io.codeffeine.brugge.domain.security.contract.user.AuthUserInterface;
import io.codeffeine.brugge.domain.security.contract.user.ChangeRoleToUserInterface;
import io.codeffeine.brugge.domain.security.contract.user.ChangeUserPasswordInterface;
import io.codeffeine.brugge.domain.security.contract.user.CheckIfTheUserHasPermissionInterface;
import io.codeffeine.brugge.domain.security.contract.user.CheckIfUserExistInterface;
import io.codeffeine.brugge.domain.security.contract.user.GetUserInterface;
import io.codeffeine.brugge.domain.security.contract.user.NewUserInterface;
import io.codeffeine.brugge.domain.security.contract.user.RecoverUserPasswordInterface;
import io.codeffeine.brugge.domain.security.repository.UserRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.repository.UserRepository;
import io.codeffeine.brugge.usecase.security.user.AuthUser;
import io.codeffeine.brugge.usecase.security.user.ChangeRoleToUser;
import io.codeffeine.brugge.usecase.security.user.ChangeUserPassword;
import io.codeffeine.brugge.usecase.security.user.CheckIfTheUserHasPermission;
import io.codeffeine.brugge.usecase.security.user.CheckIfUserExist;
import io.codeffeine.brugge.usecase.security.user.GetUser;
import io.codeffeine.brugge.usecase.security.user.NewUser;
import io.codeffeine.brugge.usecase.security.user.RecoverUserPassword;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class UserModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserRepositoryInterface.class).to(UserRepository.class);
        bind(ChangeUserPasswordInterface.class).to(ChangeUserPassword.class);
        bind(CheckIfUserExistInterface.class).to(CheckIfUserExist.class);
        bind(NewUserInterface.class).to(NewUser.class);
        bind(RecoverUserPasswordInterface.class).to(RecoverUserPassword.class);
        bind(GetUserInterface.class).to(GetUser.class);
        bind(ChangeRoleToUserInterface.class).to(ChangeRoleToUser.class);
        bind(CheckIfTheUserHasPermissionInterface.class).to(CheckIfTheUserHasPermission.class);
        bind(AuthUserInterface.class).to(AuthUser.class);
    }
}
