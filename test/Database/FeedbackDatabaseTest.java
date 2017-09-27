/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Feedback.Feedback;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gebruiker
 */
public class FeedbackDatabaseTest {
    
    public FeedbackDatabaseTest() {
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
     * Test of getAllFeedback method, of class FeedbackDatabase.
     */
    @Test
    public void testGetAllFeedback() {
        System.out.println("getAllFeedback");
//        FeedbackDatabase instance = new FeedbackDatabase();
//        ArrayList<Feedback> expResult = null;
//        ArrayList<Feedback> result = instance.getAllFeedback();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeedbackSendedReceivedUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedReceivedUser() {
        System.out.println("getFeedbackSendedReceivedUser");
//        int id = 0;
//        FeedbackDatabase instance = new FeedbackDatabase();
//        ArrayList<Feedback> expResult = null;
//        ArrayList<Feedback> result = instance.getFeedbackSendedReceivedUser(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeedbackSendedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedByUser() {
        System.out.println("getFeedbackSendedByUser");
//        int id = 0;
//        FeedbackDatabase instance = new FeedbackDatabase();
//        ArrayList<Feedback> expResult = null;
//        ArrayList<Feedback> result = instance.getFeedbackSendedByUser(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeedbackReceivedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackReceivedByUser() {
        System.out.println("getFeedbackReceivedByUser");
//        int id = 0;
//        FeedbackDatabase instance = new FeedbackDatabase();
//        ArrayList<Feedback> expResult = null;
//        ArrayList<Feedback> result = instance.getFeedbackReceivedByUser(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLikesOfFeedback & giveLikeToFeedback & removeLikeFromFeedback method, of class FeedbackDatabase.
     */
    @Test
    public void testGiveGetRemoveLikeOfFeedback() {
        System.out.println("giveLikeToFeedback");

        assertTrue("give like 1 failed", FeedbackDatabase.giveLikeToFeedback(1, 1, true));
        assertTrue("give like 2 failed", FeedbackDatabase.giveLikeToFeedback(1, 2, false));

        assertTrue("Less than 2 likes found", FeedbackDatabase.getLikesOfFeedback(1).size() >= 2);
        
        assertTrue("remove like failed", FeedbackDatabase.removeLikeFromFeedback(1, 1));
        assertTrue("remove like failed", FeedbackDatabase.removeLikeFromFeedback(1, 2));
    }
}
