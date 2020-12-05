/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;


/**
 *
 * @author Remi
 */
//@ManagedBean(name="courseBean")
//@RequestScoped
@Entity
@Table(name="COURSE")
public class Course implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CODE")
    private Integer code;
    
    @Column(name="TITLE")
    private String title;

    @OneToMany(targetEntity=Session.class, mappedBy="course")
    private List<Session> sessions = new ArrayList();
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
    
    public void addSession(Session session){
        sessions.add(session);
        session.setCourse(this);
    }
    
    public void removeSession(Session session){
        sessions.remove(session);
        session.setCourse(this);
    }
}
