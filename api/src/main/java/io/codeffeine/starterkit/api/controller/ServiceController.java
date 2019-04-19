/*
 * StarterKit.
 */
package io.codeffeine.starterkit.api.controller;

import io.codeffeine.starterkit.api.adapter.response.ResponseAdapter;
import io.codeffeine.starterkit.api.configuration.PathConfiguration;
import io.codeffeine.starterkit.domain.security.entity.User;
import io.codeffeine.starterkit.facade.container.ServiceContainer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
@RestController
@RequestMapping(PathConfiguration.API_PATH + "/services")
public class ServiceController {

    @Autowired
    private ServiceContainer sc;

    @Autowired
    private ResponseAdapter response;

    @ModelAttribute("user")
    public User getClientUser(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getServices(
            @ModelAttribute("user") User user
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getServices().getServices(user)
        );
    }

    @RequestMapping(
            value = "/{id:\\d+}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getService(
            @ModelAttribute("user") User user,
            @PathVariable int id
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getServices().getService(user, id)
        );
    }

    @RequestMapping(
            value = "/methods",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getMethods(
            @ModelAttribute("user") User user
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getServices().getSecureMethods(user)
        );
    }

    @RequestMapping(
            value = "/{service:\\d+}/methods",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getMethodsByService(
            @ModelAttribute("user") User user,
            @PathVariable int service
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getServices().getSecureMethodsByService(user, service)
        );
    }

    @RequestMapping(
            value = "/{service:\\d+}/methods/{method:\\d+}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getMethod(
            @ModelAttribute("user") User user,
            @PathVariable int service,
            @PathVariable int method
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getServices().getSecureMethodById(user, service, method)
        );
    }
}
