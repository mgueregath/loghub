/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.repository;

import io.codeffeine.brugge.domain.entity.LogType;
import java.util.List;

/**
 *
 * @author mguer
 */
public interface LogTypeRepositoryInterface {

    public LogType findById(int id);

    public LogType findByKey(String key);

    public List<LogType> findAll();
}
