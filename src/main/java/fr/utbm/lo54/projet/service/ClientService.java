/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.repository.EntityClientDao;

/**
 *
 * @author Remi
 */
public class ClientService {
    
    public void registerClient (Client c) {
        EntityClientDao ecd = new EntityClientDao();
        ecd.save(c);
    }
}
