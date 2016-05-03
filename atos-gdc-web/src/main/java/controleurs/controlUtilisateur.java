/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import dataAccessObject.Dao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import entites.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Named(value = "controlUtilisateur")
@SessionScoped
public class controlUtilisateur implements Serializable {
    @Inject
    private dataAccessObject.IdaoLocal dao;
    private String username;
    private String password;
    //private Dao d= new Dao();
    

    /**
     * Creates a new instance of controlUtilisateur
     */
    public controlUtilisateur() {
    }
    public List<Utilisateur> allUsers(){
        return dao.getALLutilisateur();
    }
    public void setList(List<Utilisateur>lst){
            
    }
    public String loginControl(){
           if(dao.loginControl(username, password)){
               return "employeur.xhtml?faces-redirect=true";
           }
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "login ou mot de passe invalide!!!"));
            return "";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
