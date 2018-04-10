/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.module.security;

import cl.emendare.starterkit.domain.security.contract.user.AuthUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.ChangeRoleToUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.ChangeUserPasswordInterface;
import cl.emendare.starterkit.domain.security.contract.user.CheckIfTheUserHasPermissionInterface;
import cl.emendare.starterkit.domain.security.contract.user.CheckIfUserExistInterface;
import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.NewUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.RecoverUserPasswordInterface;
import cl.emendare.starterkit.domain.security.repository.UserRepositoryInterface;
import cl.emendare.starterkit.persistence.postgresql.repository.UserRepository;
import cl.emendare.starterkit.usecase.security.user.AuthUser;
import cl.emendare.starterkit.usecase.security.user.ChangeRoleToUser;
import cl.emendare.starterkit.usecase.security.user.ChangeUserPassword;
import cl.emendare.starterkit.usecase.security.user.CheckIfTheUserHasPermission;
import cl.emendare.starterkit.usecase.security.user.CheckIfUserExist;
import cl.emendare.starterkit.usecase.security.user.GetUser;
import cl.emendare.starterkit.usecase.security.user.NewUser;
import cl.emendare.starterkit.usecase.security.user.RecoverUserPassword;
import com.google.inject.AbstractModule;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
