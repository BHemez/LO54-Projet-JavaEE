/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Remi
 */
public class EntityClientDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
    EntityManager entityManager = null;
    
    public void save(Client cli) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cli);
        entityManager.getTransaction().commit();  
    }
    
    public void update(Client cli) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cli);
        entityManager.getTransaction().commit();  
    }
    
    public boolean login(String email, String password){
        entityManager = entityManagerFactory.createEntityManager();
        try{
            Client c = entityManager.createQuery("from Client c WHERE c.email = :email AND c.password = :password", Client.class).setParameter("email", email).setParameter("password",password).getSingleResult();
            if(c !=null){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    public Client findById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Client.class, id);
    }
    
    public List<Client> findAll() {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Client").getResultList();
    }
    
    public void deleteById(Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        Client client = entityManager.find(Client.class, id);
        entityManager.getTransaction().begin();
        client.getSessions().forEach(session -> {
            session.getClients().remove(client);
        });    
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }
}
