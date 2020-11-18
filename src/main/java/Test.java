/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remi
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.utbm.lo54.projet.entity.Session;
import fr.utbm.lo54.projet.entity.Client;

public class Test {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        
        try {
            
            entityManagerFactory = Persistence.createEntityManagerFactory("school");
            entityManager = entityManagerFactory.createEntityManager();
        
            Client client = entityManager.find( Client.class, 1 );            
            System.out.println( "Rôles associés à Anderson" );
            for( Session associatedSession : client.getSessions() ) {
                System.out.println( associatedSession );
            }

            Session session = entityManager.find( Session.class, 1 );            
            System.out.println( "Utilisateurs possédant le rôle client" );
            for( Client associatedClient : session.getClients() ) {
                System.out.println( associatedClient );
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }

    }
}
