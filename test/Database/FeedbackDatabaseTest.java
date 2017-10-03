/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Feedback.Feedback;
import Feedback.FeedbackRequest;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piete
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
        assertTrue("geen feedback gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackSendedReceivedUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedReceivedUser() {
        System.out.println("getFeedbackSendedReceivedUser");
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackSendedReceivedUser(2);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackSendedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedByUser() {
        System.out.println("getFeedbackSendedByUser");
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackSendedByUser(2);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackReceivedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackReceivedByUser() {
        System.out.println("getFeedbackReceivedByUser");
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackReceivedByUser(2);
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

    

    /**
     * Test of getFeedbackRequestSend method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackRequestSend() {
        FeedbackDatabase.InsertFeedbackRequest(1, 1);
        ArrayList<FeedbackRequest> a = FeedbackDatabase.getFeedbackRequestSend(1);
        assertEquals(1, a.get(0).getIDto());
        assertEquals(1, a.get(0).getIDFrom());
        assertEquals("test test", a.get(0).getNameFrom());
        assertEquals("test test", a.get(0).getNameTo());
    }

    /**
     * Test of getFeedbackRequestRecieved method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackRequestRecieved() {
        FeedbackDatabase.InsertFeedbackRequest(1, 1);
        ArrayList<FeedbackRequest> a = FeedbackDatabase.getFeedbackRequestRecieved(1);
        assertEquals(1, a.get(0).getIDto());
        assertEquals(1, a.get(0).getIDFrom());
        assertEquals("test test", a.get(0).getNameFrom());
        assertEquals("test test", a.get(0).getNameTo());
    }

}