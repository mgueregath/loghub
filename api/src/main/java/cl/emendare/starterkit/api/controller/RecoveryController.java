/*
 * Tasty.
 */
package cl.emendare.starterkit.api.controller;

import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.container.ServiceContainer;
import cl.emendare.starterkit.usecase.exception.auth.UnauthorizedException;
import cl.emendare.starterkit.usecase.exception.businessrule.password.PasswordNotChangedException;
import cl.emendare.starterkit.usecase.exception.jwt.JwtValidationException;
import cl.emendare.starterkit.usecase.exception.jwt.MalformedJwtException;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Controller
@RequestMapping("/auth")
public class RecoveryController {

    @Autowired
    private ServiceContainer sc;

    @ModelAttribute("user")
    public User getClientUser(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }

    @GetMapping("/recovery")
    public String recovery(
            @ModelAttribute("user") User user,
            @RequestParam(name = "token") String token,
            Model model
    ) {
        try {
            sc.getAuthenticationService().validateTokenForPasswordRecovery(token);
            model.addAttribute("token", token);
            return "recovery";
        } catch (UnauthorizedException | JwtValidationException | MalformedJwtException | PasswordNotChangedException ex) {
            return "failure";
        }
    }

    @RequestMapping(
            value = "/recovery/set",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String recovery(
            @ModelAttribute("user") User user,
            @RequestBody MultiValueMap body
    ) {
        try {
            sc.getUserService().changePassword(
                    user,
                    ((LinkedList<String>) body.get("token")).get(0),
                    ((LinkedList<String>) body.get("password")).get(0),
                    ((LinkedList<String>) body.get("repeated")).get(0));
            return "success";

        } catch (UnauthorizedException | JwtValidationException | MalformedJwtException | PasswordNotChangedException ex) {
            return "failure";
        }

    }
}
