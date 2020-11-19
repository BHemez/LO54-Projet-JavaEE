/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Client;
import java.util.List;
import java.util.Optional;
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

    public Optional<Client> save(Client cli) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cli);
            entityManager.getTransaction().commit();
            return Optional.of(cli);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Client> findById(Integer id) {
        Client client = entityManager.find(Client.class, id);
        return client != null ? Optional.of(client) : Optional.empty();
    }

    public List<Client> findAll() {
        return entityManager.createQuery("from Client").getResultList();
    }

    public void deleteById(Integer id) {
        // Retrieve the movie with this ID
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            try {
                // Start a transaction because we're going to change the database
                entityManager.getTransaction().begin();

                // Remove all references to this movie by superheroes
                client.getSessions().forEach(session -> {
                    session.getClients().remove(client);
                });

                // Now remove the movie
                entityManager.remove(client);

                // Commit the transaction
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
