/*
 * StarterKit.
 */
package io.codeffeine.starterkit.facade.module.security;

import io.codeffeine.starterkit.domain.security.contract.user.AuthUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.ChangeRoleToUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.ChangeUserPasswordInterface;
import io.codeffeine.starterkit.domain.security.contract.user.CheckIfTheUserHasPermissionInterface;
import io.codeffeine.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import io.codeffeine.starterkit.domain.security.contract.user.GetUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.NewUserInterface;
import io.codeffeine.starterkit.domain.security.contract.user.RecoverUserPasswordInterface;
import io.codeffeine.starterkit.domain.security.repository.UserRepositoryInterface;
import io.codeffeine.starterkit.persistence.postgresql.repository.UserRepository;
import io.codeffeine.starterkit.usecase.security.user.AuthUser;
import io.codeffeine.starterkit.usecase.security.user.ChangeRoleToUser;
import io.codeffeine.starterkit.usecase.security.user.ChangeUserPassword;
import io.codeffeine.starterkit.usecase.security.user.CheckIfTheUserHasPermission;
import io.codeffeine.starterkit.usecase.security.user.CheckIfUserExist;
import io.codeffeine.starterkit.usecase.security.user.GetUser;
import io.codeffeine.starterkit.usecase.security.user.NewUser;
import io.codeffeine.starterkit.usecase.security.user.RecoverUserPassword;
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
