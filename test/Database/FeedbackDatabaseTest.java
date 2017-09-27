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
        ArrayList<Feedback> result = FeedbackDatabase.getAllFeedback();
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackSendedReceivedUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedReceivedUser() {
        System.out.println("getFeedbackSendedReceivedUser");
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackSendedReceivedUser(1);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackSendedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedByUser() {
        System.out.println("getFeedbackSendedByUser");
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackSendedByUser(1);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackReceivedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackReceivedByUser() {
        System.out.println("getFeedbackReceivedByUser");
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackReceivedByUser(1);
        assertTrue("niets gevonden", result.size() > 0);
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
