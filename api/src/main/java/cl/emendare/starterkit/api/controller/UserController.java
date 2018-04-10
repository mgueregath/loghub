/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.controller;

import cl.emendare.starterkit.api.adapter.response.ResponseAdapter;
import cl.emendare.starterkit.api.command.CreateUserCommand;
import cl.emendare.starterkit.api.command.SearchCommand;
import cl.emendare.starterkit.api.configuration.PathConfiguration;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.container.ServiceContainer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@RestController
@RequestMapping(PathConfiguration.API_PATH + "/users")
public class UserController {

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
    ResponseEntity getUsers(
            @ModelAttribute("user") User user
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getUserService().getUsers(user)
        );
    }

    @RequestMapping(
            value = "/page/{page:\\d+}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getUsers(
            @ModelAttribute("user") User user,
            @PathVariable int page
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getUserService().getPaginatedUsers(user, page)
        );
    }

    @RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity searchPersons(
            @ModelAttribute("user") User user,
            @RequestBody SearchCommand search
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getUserService().searchUser(user, search.getSearch())
        );
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity newUser(
            @ModelAttribute("user") User user,
            @RequestBody CreateUserCommand userToCreate
    ) {
        return response.send(
                true,
                HttpStatus.CREATED,
                sc.getUserService().newUser(
                        user, userToCreate.getUsername(),
                        userToCreate.getPassword(),
                        userToCreate.getRepeatedPassword(),
                        userToCreate.getEmail(), userToCreate.getRole().getId()
                )
        );
    }

    @RequestMapping(
            value = "/{userId:\\d+}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getUser(
            @ModelAttribute("user") User user,
            @PathVariable int userId
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getUserService().getUser(user, userId)
        );
    }

    @RequestMapping(
            value = "/{userId:\\d+}/role",
            method = RequestMethod.PUT,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity changeRoleToUser(
            @ModelAttribute("user") User user,
            @PathVariable int userId,
            @RequestBody User userToEdit
    ) {
        return response.send(
                true,
                HttpStatus.ACCEPTED,
                sc.getUserService().changeRole(
                        user, userId, userToEdit.getRole().getId()
                )
        );
    }

    @RequestMapping(
            value = "/roles/{roleId:\\d+}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getUsersByRole(
            @ModelAttribute("user") User user,
            @PathVariable int roleId
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getUserService().getUsersByRole(user, roleId)
        );
    }

}
