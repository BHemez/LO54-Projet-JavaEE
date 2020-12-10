/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.utbm.lo54.projet.entity.Course;
import java.util.List;

/**
 *
 * @author Remi
 */
public class EntityCourseDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
    EntityManager entityManager = null;
    
    public void save(Course c) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }
    
    public Course findById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Course.class, id);
    }
    
    public Course findByTitle(String title) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Course.class, title);
    }
    
    public List<Course> findAll() {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Course").getResultList();
    }
    
    public void deleteById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        Course c = entityManager.find(Course.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();
    }
}
