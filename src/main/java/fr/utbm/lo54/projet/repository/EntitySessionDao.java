/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.entity.Session;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Remi
 */
public class EntitySessionDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
    EntityManager entityManager = null;
    
    
    public Optional<Session> save(Session s) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(s);
            entityManager.getTransaction().commit();
            return Optional.of(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Session> findById(Integer id) {
        Session s = entityManager.find(Session.class, id);
        return s != null ? Optional.of(s) : Optional.empty();
    }

    public List<Session> findAll() {
        return entityManager.createQuery("from Session").getResultList();
    }

    public void deleteById(Integer id) {
        Session s = entityManager.find(Session.class, id);
        if (s != null) {
            try {
                entityManager.getTransaction().begin();

                s.getClients().forEach(client -> {
                    client.getSessions().remove(s);
                });

                entityManager.remove(s);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
