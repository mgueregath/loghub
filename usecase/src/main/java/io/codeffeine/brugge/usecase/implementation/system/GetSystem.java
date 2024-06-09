/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.usecase.implementation.system;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.contract.system.GetSystemInterface;
import io.codeffeine.brugge.domain.entity.System;
import io.codeffeine.brugge.domain.repository.SystemRepositoryInterface;
import io.codeffeine.brugge.usecase.exception.data.DataNotFoundException;
import java.util.List;

/**
 *
 * @author mguer
 */
public class GetSystem implements GetSystemInterface {

    private final SystemRepositoryInterface repository;

    @Inject
    public GetSystem(SystemRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public System getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public System getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public System getByKey(String key) {
        System system = repository.findByKey(key);
        if (system == null) {
            throw new DataNotFoundException();
        }
        return system;
    }

    @Override
    public List<System> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
