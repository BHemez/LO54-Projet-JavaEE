/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.service.SessionService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Remi
 */
@ManagedBean(name="sview")
@ViewScoped
public class SessionsView implements Serializable {
    
    private static final long serialVersionUID = 1L;
     
    private List<Session> sessions;
    private List<Session> filteredSessions;
    private List<String> locations;
            
    public SessionsView(){
        SessionService ss = new SessionService();
        sessions = ss.listSession();
        locations = ss.listLocation();
    }
    
    public void registerClient(){
        
    }
    
    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Session> getFilteredSessions() {
        return filteredSessions;
    }

    public void setFilteredSessions(List<Session> filteredSessions) {
        this.filteredSessions = filteredSessions;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
    
    
}
