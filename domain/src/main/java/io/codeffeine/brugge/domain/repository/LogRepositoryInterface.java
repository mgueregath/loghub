/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.repository;

import io.codeffeine.brugge.domain.entity.Log;
import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.entity.System;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mguer
 */
public interface LogRepositoryInterface {

    public Log findById(int id);

    public List<Log> findBySystem(System system);

    public List<Log> findByParams(int page, System system, LogType logType, String order, String orderParam, String searchText, Date startDate, Date endDate);

    public Log persist(Log system, Object extra);

}
