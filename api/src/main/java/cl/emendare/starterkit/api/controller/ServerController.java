/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.controller;

import cl.emendare.starterkit.api.adapter.response.ResponseAdapter;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.container.ServiceContainer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServiceContainer sc;

    @Autowired
    private ResponseAdapter response;

    @ModelAttribute("user")
    public User getClientUser(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }

    @RequestMapping(
            value = "/usage",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getServerUsage(
            @ModelAttribute("user") User user
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getServerService().getServerUsage(user)
        );
    }
}
