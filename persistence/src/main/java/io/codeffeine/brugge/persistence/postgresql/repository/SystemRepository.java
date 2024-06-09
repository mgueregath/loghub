/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.persistence.postgresql.repository;

import com.google.inject.Inject;
import io.codeffeine.brugge.domain.entity.System;
import io.codeffeine.brugge.domain.repository.SystemRepositoryInterface;
import io.codeffeine.brugge.domain.security.entity.Role;
import io.codeffeine.brugge.persistence.exception.PersistingException;
import io.codeffeine.brugge.persistence.postgresql.PostgreSQLSession;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mguer
 */
public class SystemRepository implements SystemRepositoryInterface {

    private final SessionFactory sessionFactory;

    @Inject
    public SystemRepository(PostgreSQLSession postgreSQLSession) {
        this.sessionFactory = postgreSQLSession.getSessionFactory();
    }

    @Override
    public System findById(int id) {
        Session session = sessionFactory.openSession();
        System system = session.get(System.class, id);
        session.close();
        return system;
    }

    @Override
    public List<System> findAll() {
        Session session = sessionFactory.openSession();
        List<System> systems = session
                .createQuery("SELECT s FROM System s")
                .getResultList();
        session.close();
        return systems;
    }

    @Override
    public System persist(System system) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            system = (System) session.merge(system);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistingException();
        } finally {
            session.close();
        }
        return system;
    }

    @Override
    public System findByKey(String key) {
        Session session = sessionFactory.openSession();
        List<System> systems = session
                .createQuery("SELECT s FROM System s WHERE s.key = :key")
                .setParameter("key", key)
                .getResultList();
        session.close();
        if (systems.isEmpty()) {
            return null;
        }
        return systems.get(0);
    }

}
