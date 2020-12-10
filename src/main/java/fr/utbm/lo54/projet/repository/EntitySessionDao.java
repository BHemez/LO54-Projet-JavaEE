/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Session;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        return entityManager.createQuery("from Session s", Session.class).getResultList();
    }
    
    public List<String> findLocations(){
        List<String> lis = new ArrayList<String>();
        entityManager = entityManagerFactory.createEntityManager();
        List<Session> s = entityManager.createQuery("from Session s", Session.class).getResultList();
        for(int i = 0; i < s.size(); i++)
        {
            lis.add(s.get(i).getLocation().getCity());
        }
        Set<String> uniqueLoc = new HashSet<String>(lis);
        List<String> finalList = new ArrayList<String>();
        finalList.addAll(uniqueLoc);
        return finalList;
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
