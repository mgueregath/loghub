/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.domain.entity;

import io.codeffeine.brugge.domain.migration.entity.MigratedEntity;

/**
 *
 * @author mguer
 */
public class LogType extends MigratedEntity {

    private int id;
    private String name;
    private String key;
    private int level;

    public LogType() {

    }

    public LogType(int domainId, String name, String key, int level) {
        super(domainId);
        this.name = name;
        this.key = key;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
