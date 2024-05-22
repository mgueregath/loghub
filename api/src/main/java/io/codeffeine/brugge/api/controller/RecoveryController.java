/*
 * Tasty.
 */
package io.codeffeine.brugge.api.controller;

import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.facade.container.ServiceContainer;
import io.codeffeine.brugge.usecase.exception.auth.UnauthorizedException;
import io.codeffeine.brugge.usecase.exception.businessrule.password.PasswordNotChangedException;
import io.codeffeine.brugge.usecase.exception.jwt.JwtValidationException;
import io.codeffeine.brugge.usecase.exception.jwt.MalformedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.LinkedList;
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
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
