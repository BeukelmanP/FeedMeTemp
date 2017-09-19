/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Login.User;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Dirkx
 */
public class DatabaseTest {
    
    public DatabaseTest() {
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

    /**
     * Test of connectToDB method, of class Database.
     */
    @Test
    public void testConnectToDB() {
        System.out.println("connectToDB");
        Database instance = new Database();
        boolean result = instance.connectToDB();
        assertTrue(result);
        instance.disconnectFromDB();
    }

    /**
     * Test of getConn method, of class Database.
     */
    @Test
    public void testGetConn() {
        System.out.println("getConn");
        Database instance = new Database();
        instance.connectToDB(); //connect to database before attempting to get it
        Connection result = instance.getConn();
        assertNotNull(result);
        instance.disconnectFromDB();
    }

    /**
     * Test of disconnectFromDB method, of class Database.
     */
    @Test
    public void testDisconnectFromDB() {
        System.out.println("disconnectFromDB");
        Database instance = new Database();
        instance.connectToDB(); //connect to database before attempting disconnect
        boolean result = instance.disconnectFromDB();
        assertTrue(result);
    }
    
    /**
     * Test of getAllUsers method, of class Database.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        Database instance = new Database();
        instance.connectToDB(); //connect to database before attempting disconnect
        ArrayList<User> result = instance.getAllUsers();
        assertTrue(result.size() > 0);
        instance.disconnectFromDB(); //disconnect after test
    }
    
    /**
     * Test of getAllFeedback method, of class Database.
     */
    @Test
    public void testGetAllFeedback() {
        System.out.println("getAllFeedback");
        Database instance = new Database();
        instance.connectToDB(); //connect to database before attempting action
        ArrayList<User> result = instance.getAllUsers();
        assertTrue(result.size() > 0);
        instance.disconnectFromDB(); //disconnect after test
    }
}
