/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.domain.entity;

import java.util.Date;

/**
 *
 * @author mguer
 */
public class Log {

    private long id;
    private Date date;
    private System system;
    private String reason;
    private LogType logType;
    private String details;

    public Log(System system, String reason, LogType logType, String details) {
        this.date = new Date();
        this.system = system;
        this.reason = reason;
        this.logType = logType;
        this.details = details;
    }

    public Log() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the system
     */
    public System getSystem() {
        return system;
    }

    /**
     * @param system the system to set
     */
    public void setSystem(System system) {
        this.system = system;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the logType
     */
    public LogType getLogType() {
        return logType;
    }

    /**
     * @param logType the logType to set
     */
    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

}
