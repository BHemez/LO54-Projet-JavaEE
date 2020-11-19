/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import fr.utbm.lo54.projet.entity.Course;
import fr.utbm.lo54.projet.entity.Session;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Remi
 */
public class EntityCourseDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
    EntityManager entityManager = null;
    
    public Optional<Course> save(Course c) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
            return Optional.of(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Course> findById(Integer id) {
        Course c = entityManager.find(Course.class, id);
        return c != null ? Optional.of(c) : Optional.empty();
    }

    public List<Course> findAll() {
        return entityManager.createQuery("from Course").getResultList();
    }

    public void deleteById(Integer id) {
        Course c = entityManager.find(Course.class, id);
        if (c != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(c);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
