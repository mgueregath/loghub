/*
 * StarterKit.
 */
package io.codeffeine.starterkit.api.controller;

import io.codeffeine.starterkit.api.adapter.response.ResponseAdapter;
import io.codeffeine.starterkit.api.command.LoginCommand;
import io.codeffeine.starterkit.api.command.RecoveryCommand;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.facade.container.ServiceContainer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private ServiceContainer sc;

    @Autowired
    private ResponseAdapter response;

    @ModelAttribute("user")
    public User getClientUser(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity login(
            @ModelAttribute("user") User user,
            @RequestBody LoginCommand credentials
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getAuthenticationService().loginUser(
                        user, credentials.getUsername(),
                        credentials.getPassword()
                )
        );
    }

    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity logout(
            @ModelAttribute("user") User user
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getAuthenticationService().logoutUser(user)
        );
    }

    @RequestMapping(
            value = "/recovery",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity recovery(
            @ModelAttribute("user") User user,
            @RequestBody RecoveryCommand credentials
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getAuthenticationService().recoverUserPassword(
                        user, credentials.getUsername()
                )
        );
    }
}
