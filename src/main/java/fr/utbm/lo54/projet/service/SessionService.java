/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.entity.Session;
import fr.utbm.lo54.projet.repository.EntitySessionDao;

/**
 *
 * @author Remi
 */
public class SessionService {
    
    public void registerSession(Session s) {
        EntitySessionDao esd = new EntitySessionDao();
        esd.save(s);
    }
}
