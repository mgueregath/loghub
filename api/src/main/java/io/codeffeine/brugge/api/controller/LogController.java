/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.api.controller;

import io.codeffeine.brugge.api.adapter.response.ResponseAdapter;
import io.codeffeine.brugge.api.command.ChangePasswordCommand;
import io.codeffeine.brugge.api.command.NewLogCommand;
import io.codeffeine.brugge.api.configuration.PathConfiguration;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.facade.container.ServiceContainer;
import jakarta.servlet.http.HttpServletRequest;
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
 * @author mguer
 */
@RestController
@RequestMapping(PathConfiguration.API_PATH + "/logs")
public class LogController {

    @Autowired
    private ServiceContainer sc;

    @Autowired
    private ResponseAdapter response;

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    ResponseEntity addLog(
            @ModelAttribute("user") User user,
            @RequestBody NewLogCommand command
    ) {
        return response.send(
                true,
                HttpStatus.CREATED,
                sc.getLogService().addLog(
                        user, command.getSystemKey(), command.getReason(),
                        command.getType(), command.getDetails(), command.getData()
                )
        );
    }

}
