/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.service.ClientService;
import fr.utbm.lo54.projet.service.SessionService;
import fr.utbm.lo54.projet.tools.SessionUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    
    public void registerClientSession(int sessionId){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession hs = SessionUtil.getSession();
        String mail = (String)hs.getAttribute("email");
        if (mail == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:","You need to login with an account") );
        } else {
            ClientService cs = new ClientService();
            SessionService ss = new SessionService();
            try {
                Session ses = ss.findSessiontById(sessionId);
                Client cli = cs.findClientByEmail(mail);
                List<Session> ls = cli.getSessions();
                boolean exist = sessionExist(sessionId, ls);
                if(exist==false){
                    cli.addSession(ses);
                    cs.updateClient(cli);
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Confirmation message has been sent on "+mail) );
                } else{
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "You are already registered to this course") );
                }
            }
            catch(Exception e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", ""+e) );
            }
        }
    }
    
    private boolean sessionExist(int sessionId, List<Session> ls){
        for(int i=0; i<ls.size(); i++){
            if(ls.get(i).getId()==sessionId){
                return true;
            }
        }
        return false;
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
