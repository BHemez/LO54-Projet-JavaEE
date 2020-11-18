/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Remi
 */
@Entity
@Table(name="COURSE_SESSION")
public class Session implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Date endDate;
    
    @Column(name="CAP_MAX")
    private Integer capMax;
    
    @ManyToMany
    @JoinTable(name = "CLIENT_SESSION", joinColumns = @JoinColumn(name = "SESSION_ID"), inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"))
    private List<Client> clients = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="COURSE_CODE")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="LOCATION_ID")
    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Course> courses) {
        this.clients = clients;
    }
    
    
}
