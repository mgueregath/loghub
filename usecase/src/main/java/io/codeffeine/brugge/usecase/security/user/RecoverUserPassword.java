/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.usecase.security.user;

import io.codeffeine.brugge.domain.mailing.contract.NewEmailInterface;
import io.codeffeine.brugge.domain.security.contract.token.GenerateTokenInterface;
import io.codeffeine.brugge.domain.security.contract.user.GetUserInterface;
import io.codeffeine.brugge.domain.security.contract.user.RecoverUserPasswordInterface;
import io.codeffeine.brugge.domain.security.entity.Token;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.domain.security.repository.UserRepositoryInterface;
import com.google.inject.Inject;
import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class RecoverUserPassword implements RecoverUserPasswordInterface {

    private final GetUserInterface getUser;
    private final UserRepositoryInterface repository;
    private final NewEmailInterface newEmail;
    private final GenerateTokenInterface generateToken;
    private static String server;

    @Inject
    public RecoverUserPassword(
            GetUserInterface getUser,
            UserRepositoryInterface repository,
            NewEmailInterface newEmail,
            GenerateTokenInterface generateToken
    ) {
        this.getUser = getUser;
        this.repository = repository;
        this.newEmail = newEmail;
        this.generateToken = generateToken;
    }

    static {
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("server.properties"));
            server = config.getString("server");
        } catch (ConfigurationException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean recover(String username) {
        User user = getUser.getByUsername(username);
        user.setAccountRecovery(true);
        Token token = generateToken.generateForSetPassword(user);

        newEmail.add(
                user.getEmail(),
                "Usuario",
                "Solicitud de recuperación de contraseña",
                "Junto con saludar, nos comunicamos ya que se ha solicitado la recuperación de su contraseña."
                + "<br>Para continuar con el proceso de recuperación, presione el botón a continuación."
                + "<br><br>"
                + "<table role='presentation' cellspacing='0' cellpadding='0' border='0' align='center' style='margin: auto'>"
                + "<tr>"
                + "<td style='border-radius: 3px; background: #4d7900; text-align: center;' class='button-td'>"
                + "<a href='" + server + "/auth/recovery?token=" + token.getToken() + "' style='background: #d3812c; border: 15px solid #d3812c; font-family: sans-serif; font-size: 13px; line-height: 1.1; text-align: center; text-decoration: none; display: block; border-radius: 3px; font-weight: bold;' class='button-a'>"
                + "<span style='color:#ffffff;' class='button-link'>&nbsp;&nbsp;&nbsp;&nbsp;Cambiar contraseña&nbsp;&nbsp;&nbsp;&nbsp;</span>"
                + "</a>"
                + "</td>"
                + "</tr>"
                + "</table>"
                + "<br><br> Si usted no ha solicitado el cambio, por favor, de todos modos realice el cambio."
        );
        repository.persist(user);
        return true;
    }
}
