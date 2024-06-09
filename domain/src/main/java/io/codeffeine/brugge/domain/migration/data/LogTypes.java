/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.domain.migration.data;

import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.migration.InitData;
import io.codeffeine.brugge.domain.security.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mguer
 */
public class LogTypes extends InitData {

    public static final int STATUS = 1;
    public static final int ERROR = 2;
    public static final int WARNING = 3;
    public static final int CRASHED = 4;
    private static final Map<Integer, LogType> logTypes = new HashMap<>();

    public LogTypes() {
        super();
        logTypes.put(STATUS, new LogType(STATUS, "Status", "status", 0));
        logTypes.put(ERROR, new LogType(ERROR, "Error", "error", 3));
        logTypes.put(WARNING, new LogType(WARNING, "Warning", "warning", 1));
        logTypes.put(CRASHED, new LogType(CRASHED, "Crashed", "crashed", 4));
    }

    public static List<LogType> getLogTypes() {
        return new ArrayList<>(logTypes.values());
    }

    public static LogType getById(int id) {
        return logTypes.get(id);
    }

    @Override
    public Class getTargetClass() {
        return LogType.class;
    }

    @Override
    public List<?> getData() {
        return getLogTypes();
    }

    @Override
    public void setData(List<Object> data) {
        data.forEach(item -> {
            LogType type = (LogType) item;
            logTypes.replace(type.getDomainId(), type);
        });
    }
}
