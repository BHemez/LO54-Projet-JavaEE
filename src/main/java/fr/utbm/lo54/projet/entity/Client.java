/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.service.ClientService;
import fr.utbm.lo54.projet.tools.SessionUtil;
import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Remi
 */
@ManagedBean(name="client")
@SessionScoped
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
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(unique=true, name="PASSWORD")
    private String password;
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "CLIENT_SESSION",joinColumns = @JoinColumn(name = "CLIENT_ID"),inverseJoinColumns = @JoinColumn(name = "SESSION_ID"))
    private List<Session> sessions = new ArrayList<>();
    
    public String loginControl(){
        ClientService cs = new ClientService();
        System.out.println("Login");
        if(cs.loginClient(email, password)){
            HttpSession hs = SessionUtil.getSession();
            hs.setAttribute("email",email);
            return "home.xhtml?faces-redirect=true";
        }else{
            return "";
        }
    }

    public String logoutControl(){
        HttpSession hs = SessionUtil.getSession();
        hs.invalidate();
        return "home.xhtml?faces-redirect=true";
    }
    
    public String registerControl(){
        ClientService cs = new ClientService();
        cs.registerClient(this);
        return "login.xhtml?faces-redirect=true";
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
