/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.controller;

import cl.emendare.starterkit.api.adapter.response.ResponseAdapter;
import cl.emendare.starterkit.api.configuration.PathConfiguration;
import cl.emendare.starterkit.domain.security.entity.Method;
import cl.emendare.starterkit.domain.security.entity.Role;
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
@RequestMapping(PathConfiguration.API_PATH + "/roles")
public class RoleController {

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
    ResponseEntity getRoles(
            @ModelAttribute("user") User user
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getRoleService().getRoles(user)
        );
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity newRole(
            @ModelAttribute("user") User user,
            @RequestBody Role role
    ) {
        return response.send(
                true,
                HttpStatus.CREATED,
                sc.getRoleService().newRole(user, role.getName())
        );
    }

    @RequestMapping(
            value = "/{roleId:\\d+}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getRole(
            @ModelAttribute("user") User user,
            @PathVariable int roleId
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getRoleService().getRole(user, roleId)
        );
    }

    @RequestMapping(
            value = "/{roleId:\\d+}",
            method = RequestMethod.PUT,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity editRole(
            @ModelAttribute("user") User user,
            @PathVariable int roleId,
            @RequestBody Role role
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getRoleService().editRole(user, roleId, role.getName())
        );
    }

    @RequestMapping(
            value = "/{roleId:\\d+}",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity deleteRole(
            @ModelAttribute("user") User user,
            @PathVariable int roleId
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getRoleService().deleteRole(user, roleId)
        );
    }

    @RequestMapping(
            value = "/{roleId:\\d+}/users",
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

    @RequestMapping(
            value = "/{roleId:\\d+}/permissions",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity getRolePermissions(
            @ModelAttribute("user") User user,
            @PathVariable int roleId
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getRoleService().getPermissionsByRole(user, roleId)
        );
    }

    @RequestMapping(
            value = "/{roleId:\\d+}/permissions",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity addPermissionToRole(
            @ModelAttribute("user") User user,
            @PathVariable int roleId,
            @RequestBody Method method
    ) {
        return response.send(
                true,
                HttpStatus.CREATED,
                sc.getRoleService().addPermissionToRole(
                        user, roleId, method.getService(), method.getMethod()
                )
        );
    }

    @RequestMapping(
            value = "/{roleId:\\d+}/permissions",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity deletePermissionFromRole(
            @ModelAttribute("user") User user,
            @PathVariable int roleId,
            @RequestBody Method method
    ) {
        return response.send(
                true,
                HttpStatus.OK,
                sc.getRoleService().removePermissionToRole(
                        user, roleId, method.getService(), method.getMethod()
                )
        );
    }

}
