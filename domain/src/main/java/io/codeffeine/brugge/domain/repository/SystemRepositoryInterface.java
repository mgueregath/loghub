/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.repository;

import java.util.List;
import io.codeffeine.brugge.domain.entity.System;

/**
 *
 * @author mguer
 */
public interface SystemRepositoryInterface {

    public System findById(int id);

    public System findByKey(String key);

    public List<System> findAll();

    public System persist(System system);
}
