/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import entites.*;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Named(value = "controlUtilisateur")
@SessionScoped
public class controlUtilisateur implements Serializable {
    @EJB
    private dataAccessObject.IdaoLocal dao;

    /**
     * Creates a new instance of controlUtilisateur
     */
    public controlUtilisateur() {
    }
    public List<Utilisateur> allUsers(){
        return dao.getALLutilisateur();
    }
    
}
