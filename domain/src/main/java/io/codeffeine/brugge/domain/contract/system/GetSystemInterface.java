/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.contract.system;

import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.entity.System;
import java.util.List;

/**
 *
 * @author mguer
 */
public interface GetSystemInterface {

    public System getById(int id);

    public System getByName(String name);

    public System getByKey(String key);

    public List<System> getAll();
}
