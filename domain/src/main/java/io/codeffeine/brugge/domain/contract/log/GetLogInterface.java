/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.contract.log;

import io.codeffeine.brugge.domain.entity.Log;
import io.codeffeine.brugge.domain.entity.LogType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mguer
 */
public interface GetLogInterface {

    public Log getById(int id);

    public List<Log> getBySystem(String key);

    public List<Log> getBySystem(int id);

    public List<Log> getByParams(int page, int systemId, int logTypeId, String order, String orderParam, String searchText, Date startDate, Date endDate);

}
