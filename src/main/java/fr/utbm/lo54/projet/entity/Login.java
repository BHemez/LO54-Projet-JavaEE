/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.service.ClientService;
import fr.utbm.lo54.projet.tools.SessionUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Remi
 */
@ManagedBean(name="login")
@SessionScoped
public class Login implements Serializable{
    
    private String email;
    private String password;
   
  
    public String loginControl(){
        ClientService cs = new ClientService();
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
