/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Remi
 */
public class EntityLocationDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
    EntityManager entityManager = null;
    
    public void save(Location l) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
    }
    
    public Location findById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Location.class, id);
    }
    
    public Location findByCity(String city) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Location.class, city);
    }
    
    public List<Location> findAll() {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Session").getResultList();
    }
    
    public void deleteById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        Location l = entityManager.find(Location.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(l);
        entityManager.getTransaction().commit();
    }
}
