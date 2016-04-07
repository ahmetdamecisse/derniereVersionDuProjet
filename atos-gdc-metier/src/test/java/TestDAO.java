/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dataAccessObject.IdaoLocal;
import entites.Utilisateur;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ahmet Dame CISSE
 */
public class TestDAO {
//   IdaoLocal dao = lookupDaoLocal();
    
    public TestDAO() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

      @Test
    public void aficheAllutilisateur() {
//        List listeUtili = dao.getALLutilisateur();
//        if (listeUtili != null) {
//            for (Object utili : listeUtili) {
//                Utilisateur utrecup = (Utilisateur) utili;
//                System.out.println("id: " + utrecup.getIdUtilisateur() + " nom: " + utrecup.getNom() + " prénom: " + utrecup.getPrenom() + " Localisation: " + utrecup.getLocalisation() + " Login: " + utrecup.getLogin() + " Mail: " + utrecup.getMail() + " passeword: " + utrecup.getPassword() + " specialite: " + utrecup.getSpecialite() + " Date de naissance: " + utrecup.getDateDeNaissance() + " telephone: " + utrecup.getTelephone() + " Version: " + utrecup.getVersion());
//            }
//        }
          System.out.println("888888888888888888888888888");
    }

    private IdaoLocal lookupDaoLocal() {
        try {
            Context c = new InitialContext();
            return (IdaoLocal) c.lookup("java:global/com.gdcatos_atos-gdc-ear_ear_1.0-SNAPSHOT/com.gdcatos_atos-gdc-metier_ejb_1.0-SNAPSHOT/Dao!dataAccessObject.IdaoLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
