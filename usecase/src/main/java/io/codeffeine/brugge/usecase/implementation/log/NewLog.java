/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.usecase.implementation.log;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.contract.log.NewLogInterface;
import io.codeffeine.brugge.domain.contract.log.type.GetLogTypeInterface;
import io.codeffeine.brugge.domain.contract.system.GetSystemInterface;
import io.codeffeine.brugge.domain.entity.Log;
import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.entity.System;
import io.codeffeine.brugge.domain.repository.LogRepositoryInterface;
import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;

/**
 *
 * @author mguer
 */
public class NewLog implements NewLogInterface {

    private final LogRepositoryInterface repository;
    private final GetSystemInterface getSystem;
    private final GetLogTypeInterface getLogType;

    @Inject
    public NewLog(
            LogRepositoryInterface repository,
            GetSystemInterface getSystem,
            GetLogTypeInterface getLogType
    ) {
        this.repository = repository;
        this.getSystem = getSystem;
        this.getLogType = getLogType;
    }

    @Override
    public Log add(String systemKey, String reason, String typeKey, String details, String data) {
        System system = null;
        try {
            system = getSystem.getByKey(systemKey);
        } catch (DataNotFoundException ex) {
            system = new System(systemKey);
        }
        LogType type = null;
        try {
            type = getLogType.getByKey(typeKey);
        } catch (DataNotFoundException ex) {
            // No action
        }
        Log log = new Log(system, reason, type, details);

        return repository.persist(log, data);
    }

}
