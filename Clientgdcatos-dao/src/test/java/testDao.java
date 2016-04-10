/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dataAccessObject.IdaRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ahmet Dame CISSE
 */
public class testDao {
    private static IdaRemote dao;

    @BeforeClass
    public static void init() throws NamingException {
        // initialisation environnement JNDI
        InitialContext initialContext = new InitialContext();
        // instanciation couche dao
        dao = (IdaRemote) initialContext.lookup("dataAccessObjectDistant");
    }
    public testDao() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
