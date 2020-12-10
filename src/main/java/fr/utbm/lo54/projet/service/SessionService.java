/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.entity.Session;
import fr.utbm.lo54.projet.repository.EntitySessionDao;
import java.util.List;

/**
 *
 * @author Remi
 */
public class SessionService {
    
    public void registerSession(Session s) {
        EntitySessionDao esd = new EntitySessionDao();
        esd.save(s);
    }
    
    public List<Session> listSession(){
        EntitySessionDao esd = new EntitySessionDao();
        return esd.findAll();
    }
    
    public List<String> listLocation(){
        EntitySessionDao esd = new EntitySessionDao();
        return esd.findLocations();
    }
    
    public Session findSessiontById(Integer id) {
        EntitySessionDao esd = new EntitySessionDao();
        return esd.findById(id);
    }

    public void deleteSession(Session s) {
        EntitySessionDao esd = new EntitySessionDao();
        esd.deleteById(s.getId());
    }
    
    public void updateSession(Session s) {
        EntitySessionDao esd = new EntitySessionDao();
        esd.update(s);
    }
}
