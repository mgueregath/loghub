/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.usecase.implementation.log.type;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.contract.log.type.GetLogTypeInterface;
import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.repository.LogTypeRepositoryInterface;
import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import java.util.List;

/**
 *
 * @author mguer
 */
public class GetLogType implements GetLogTypeInterface {

    private final LogTypeRepositoryInterface repository;

    @Inject
    public GetLogType(LogTypeRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public LogType getById(int id) {
        LogType logType = repository.findById(id);
        if (logType == null) {
            throw new DataNotFoundException();
        }
        return logType;
    }

    @Override
    public LogType getByKey(String key) {
        LogType logType = repository.findByKey(key);
        if (logType == null) {
            throw new DataNotFoundException();
        }
        return logType;
    }

    @Override
    public List<LogType> getAll() {
        List<LogType> types = repository.findAll();
        if (types.isEmpty()) {
            throw new DataNotFoundException();
        }
        return types;
    }

}
