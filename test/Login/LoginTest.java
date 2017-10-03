/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wesle
 */
public class LoginTest {
    
    public LoginTest() {
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
     * Test of getPassword method, of class Login.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Login instance = new Login();
        instance.setPassword("testPassword");
        String expResult = "testPassword";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Login.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "testPassword";
        Login instance = new Login();
        instance.setPassword(password);
    }

    /**
     * Test of getMessage method, of class Login.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Login instance = new Login();
        instance.setMessage("testMessage");
        String expResult = "testMessage";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class Login.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "testMessage";
        Login instance = new Login();
        instance.setMessage(message);
    }

    /**
     * Test of getUsername method, of class Login.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Login instance = new Login();
        instance.setUsername("testUsername");
        String expResult = "testUsername";
        String result = instance.getUsername();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUsername method, of class Login.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "testUsername";
        Login instance = new Login();
        instance.setUsername(username);
    }

    /**
     * Test of validateUsernamePassword method, of class Login.
     */
    @Test
    public void testValidateUsernamePassword() {
        System.out.println("validateUsernamePassword");
        Login instance = new Login();
        instance.setUsername("test");
        instance.setPassword("test");
        String expResult = "homePage";
        String result = instance.validateUsernamePassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Login.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Login instance = new Login();
        String expResult = null;
        String result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
