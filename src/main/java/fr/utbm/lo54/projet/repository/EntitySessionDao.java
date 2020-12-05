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
    
    
    public void save(Session s) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
    }
    
    public Session findById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Session.class, id);
    }
    
    public List<Session> findAll() {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Session").getResultList();
    }
    
    public void deleteById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        Session s = entityManager.find(Session.class, id);
        entityManager.getTransaction().begin();
        s.getClients().forEach(client -> {
            client.getSessions().remove(s);
        });
        entityManager.remove(s);
        entityManager.getTransaction().commit();
    }
    
    public void update(Session s) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(s);
        entityManager.getTransaction().commit();
    }
}
