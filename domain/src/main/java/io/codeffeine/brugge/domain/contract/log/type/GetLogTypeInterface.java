/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.contract.log.type;

import io.codeffeine.brugge.domain.entity.LogType;
import java.util.List;

/**
 *
 * @author mguer
 */
public interface GetLogTypeInterface {

    public LogType getById(int id);

    public LogType getByKey(String key);

    public List<LogType> getAll();

}
