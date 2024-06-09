/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.persistence.postgresql.repository;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.entity.LogType;
import io.codeffeine.brugge.domain.repository.LogTypeRepositoryInterface;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mguer
 */
public class LogTypeRepository implements LogTypeRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public LogTypeRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public LogType findById(int id) {
        Session session = sessionFactory.openSession();
        LogType type = session.get(LogType.class, id);
        session.close();
        return type;
    }

    @Override
    public List<LogType> findAll() {
        Session session = sessionFactory.openSession();
        List<LogType> types = session
                .createQuery("SELECT s FROM LogType s")
                .getResultList();
        session.close();
        return types;
    }

    @Override
    public LogType findByKey(String key) {
        Session session = sessionFactory.openSession();
        List<LogType> types = session
                .createQuery("SELECT s FROM LogType s WHERE s.key = :key")
                .setParameter("key", key)
                .getResultList();
        session.close();
        if (types.isEmpty()) {
            return null;
        }
        return types.get(0);
    }

}
