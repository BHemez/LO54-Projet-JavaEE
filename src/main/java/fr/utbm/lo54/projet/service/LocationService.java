/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.entity.Location;
import fr.utbm.lo54.projet.repository.EntityLocationDao;
import java.util.List;

/**
 *
 * @author Remi
 */
public class LocationService {
    public void registerLocation(Location l) {
        EntityLocationDao eld = new EntityLocationDao();
        eld.save(l);
    }
    
    public List<Location> listLocation(){
        EntityLocationDao eld = new EntityLocationDao();
        return eld.findAll();
    }
    
    public Location findLocationById(Integer id) {
        EntityLocationDao eld = new EntityLocationDao();
        return eld.findById(id);
    }

    public Location findLocationByCity(String city) {
        EntityLocationDao eld = new EntityLocationDao();
        return eld.findByCity(city);
    }
    
    public void deleteCourse(Location l) {
        EntityLocationDao eld = new EntityLocationDao();
        eld.deleteById(l.getId());
    }
}
