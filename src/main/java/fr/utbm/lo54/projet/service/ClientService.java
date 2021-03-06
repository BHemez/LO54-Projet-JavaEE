/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.repository.EntityClientDao;
import java.util.List;

/**
 *
 * @author Remi
 */
public class ClientService {
    
    public void registerClient (Client c) {
        EntityClientDao ecd = new EntityClientDao();
        ecd.save(c);
    }
    
    public List<Client> listClient(){
        EntityClientDao ecd = new EntityClientDao();
        return ecd.findAll();
    }
    
    public Client findClientById(Integer id) {
        EntityClientDao ecd = new EntityClientDao();
        return ecd.findById(id);
    }
    
    public Client findClientByEmail(String email) {
        EntityClientDao ecd = new EntityClientDao();
        return ecd.findByEmail(email);
    }

    public void deleteClient(Client client) {
        EntityClientDao ecd = new EntityClientDao();
        ecd.deleteById(client.getId());
    }
    
    public void updateClient(Client client) {
        EntityClientDao ecd = new EntityClientDao();
        ecd.update(client);
    }
    
    public boolean loginClient(String email, String password){
        EntityClientDao ecd = new EntityClientDao();
        return ecd.login(email, password);
    }
}
