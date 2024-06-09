/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.codeffeine.brugge.domain.contract.log;

import io.codeffeine.brugge.domain.entity.Log;
import io.codeffeine.brugge.domain.entity.LogType;

/**
 *
 * @author mguer
 */
public interface NewLogInterface {

    public Log add(String systemKey, String reason, String type, String details, String data);
}
