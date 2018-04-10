/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.security.user;

import cl.emendare.starterkit.domain.security.contract.user.GetUserInterface;
import cl.emendare.starterkit.domain.security.contract.user.RecoverUserPasswordInterface;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.domain.security.repository.UserRepositoryInterface;
import cl.emendare.starterkit.usecase.adapter.password.generator.PasswordGeneratorAdapter;
import cl.emendare.starterkit.usecase.adapter.password.hasher.PasswordHasherAdapter;
import com.google.inject.Inject;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class RecoverUserPassword implements RecoverUserPasswordInterface {

    private final GetUserInterface getUser;
    private final UserRepositoryInterface repository;
    private final PasswordGeneratorAdapter passwordGenerator;
    private final PasswordHasherAdapter passwordHasher;
    //private NewEmailInterface newEmail;

    @Inject
    public RecoverUserPassword(
            GetUserInterface getUser,
            UserRepositoryInterface repository,
            PasswordGeneratorAdapter passwordGenerator,
            PasswordHasherAdapter passwordHasher
    //NewEmailInterface newEmail
    ) {
        this.getUser = getUser;
        this.repository = repository;
        this.passwordGenerator = passwordGenerator;
        this.passwordHasher = passwordHasher;
        //this.newEmail = newEmail;
    }

    @Override
    public boolean recover(String username) {
        User user = getUser.getByUsername(username);
        String password = passwordGenerator.generate();
        user.setPassword(passwordHasher.hash(password));
        user = repository.persist(user);
        /*
        newEmail.add(
                person.getEmail(),
                person.getFirstName() + " " + person.getFirstLastName(),
                "Solicitud de recuperación de contraseña",
                "Hemos recibido una solicitud para recuperar su contraseña. "
                + "Junto con saludar, nos comunicamos ya que se ha solicitado la recuperación de su contraseña."
                + "<br>Por favor acceda al sistema con la nueva contraseña que le proporcionamos."
                + "<br><br>Nueva contraseña: <b>" + password
                + "</b>. <br><br> Esta contraseña debe ser cambiada en su primer ingreso ya que si no es modificada, no se le permitirá operar."
        );
         */
        return true;
    }
}
