/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.facade.service;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.contract.log.NewLogInterface;
import io.codeffeine.brugge.domain.entity.Log;
import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.migration.data.Roles;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.facade.permission.ServiceIdentification;
import io.codeffeine.brugge.facade.permission.annotation.Permission;
import io.codeffeine.brugge.facade.permission.annotation.ProtectedService;

/**
 *
 * @author mguer
 */
@ProtectedService(
        service = ServiceIdentification.LOGS
)
public class LogService {

    private final NewLogInterface newLog;

    @Inject
    public LogService(NewLogInterface newLog) {
        this.newLog = newLog;
    }

    @Permission(
            details = "Registrar un log",
            method = 1,
            roles = {Roles.PUBLIC}
    )
    public Log addLog(User user, String systemKey, String reason, String type, String details, String data) {
        return newLog.add(systemKey, reason, type, details, data);
    }

}
