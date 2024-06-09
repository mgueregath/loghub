/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.facade.module.logic;

import com.google.inject.AbstractModule;
import io.codeffeine.brugge.domain.contract.log.NewLogInterface;
import io.codeffeine.brugge.domain.contract.log.type.GetLogTypeInterface;
import io.codeffeine.brugge.domain.contract.system.GetSystemInterface;
import io.codeffeine.brugge.domain.repository.LogRepositoryInterface;
import io.codeffeine.brugge.domain.repository.LogTypeRepositoryInterface;
import io.codeffeine.brugge.domain.repository.SystemRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.repository.LogRepository;
import io.codeffeine.brugge.persistence.postgresql.repository.LogTypeRepository;
import io.codeffeine.brugge.persistence.postgresql.repository.SystemRepository;
import io.codeffeine.brugge.usecase.implementation.log.NewLog;
import io.codeffeine.brugge.usecase.implementation.log.type.GetLogType;
import io.codeffeine.brugge.usecase.implementation.system.GetSystem;

/**
 *
 * @author mguer
 */
public class LogModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SystemRepositoryInterface.class).to(SystemRepository.class);
        bind(LogTypeRepositoryInterface.class).to(LogTypeRepository.class);
        bind(LogRepositoryInterface.class).to(LogRepository.class);

        bind(NewLogInterface.class).to(NewLog.class);
        bind(GetSystemInterface.class).to(GetSystem.class);
        bind(GetLogTypeInterface.class).to(GetLogType.class);
    }
}
