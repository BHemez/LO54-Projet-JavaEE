/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Remi
 */
@ManagedBean(name="clientBean")
@RequestScoped
@Entity
@Table(name="CLIENT")
public class Client implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="LASTNAME")
    private String lastname;
    
    @Column(name="FIRSTNAME")
    private String firstname;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="PHONE")
    private String phone;
    
    @Column(name="EMAIL")
    private String email;
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "CLIENT_SESSION",joinColumns = @JoinColumn(name = "CLIENT_ID"),inverseJoinColumns = @JoinColumn(name = "SESSION_ID"))
    private List<Session> sessions = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Course> courses) {
        this.sessions = sessions;
    }
    
    public void addSession(Session session) {
        sessions.add(session);
        session.getClients().add(this);
    }
    
}
