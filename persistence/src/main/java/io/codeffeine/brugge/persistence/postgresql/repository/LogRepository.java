/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.persistence.postgresql.repository;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.entity.Log;
import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.entity.System;
import io.codeffeine.brugge.domain.repository.LogRepositoryInterface;
import io.codeffeine.brugge.persistence.elastic.ElasticSession;
import io.codeffeine.brugge.persistence.exception.PersistingException;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mguer
 */
public class LogRepository implements LogRepositoryInterface {

    private final SessionFactory sessionFactory;
    private final ElasticSession elasticSession;

    @Inject
    public LogRepository(
            PostgreSQLSession postgreSQLSession,
            ElasticSession elasticSession
    ) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
        this.elasticSession = elasticSession;
    }

    @Override
    public Log findById(int id) {
        Session session = sessionFactory.openSession();
        Log log = session.get(Log.class, id);
        session.close();
        return log;
    }

    @Override
    public List<Log> findBySystem(System system) {
        Session session = sessionFactory.openSession();
        List<Log> logs = session
                .createQuery("SELECT s FROM Log s WHERE log.system = :system")
                .setParameter("system", system)
                .getResultList();
        session.close();
        return logs;
    }

    @Override
    public List<Log> findByParams(int page, System system, LogType logType, String order, String orderParam, String searchText, Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Log persist(Log log, Object extra) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            log = (Log) session.merge(log);
            transaction.commit();

            final Log savedLog = log;
            final Map<String, Object> data = new HashMap<>();
            data.put("id", log.getId());
            data.put("date", log.getDate());
            data.put("system", log.getSystem());
            data.put("reason", log.getReason());
            data.put("logType", log.getLogType());
            data.put("details", log.getDetails());
            data.put("data", extra);
            elasticSession.getSession().index(i -> i.index(elasticSession.getIndex(savedLog.getSystem().getKey())).id(savedLog.getId() + "").document(data));
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException();
        } finally {
            session.close();
        }
        return log;
    }

}
