/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import dal.FeedbackDAO;
import models.Feedback;
import models.FeedbackRequest;
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
     * Test of getAllFeedback method, of class FeedbackDAO.
     */
    @Test
    public void testGetAllFeedback() {
        System.out.println("getAllFeedback");
        ArrayList<Feedback> result = FeedbackDAO.getAllFeedback();
        assertTrue("geen feedback gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackSendedReceivedUser method, of class FeedbackDAO.
     */
    @Test
    public void testGetFeedbackSendedReceivedUser() {
        System.out.println("getFeedbackSendedReceivedUser");
        ArrayList<Feedback> result = FeedbackDAO.getFeedbackSendedReceivedUser(2);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackSendedByUser method, of class FeedbackDAO.
     */
    @Test
    public void testGetFeedbackSendedByUser() {
        System.out.println("getFeedbackSendedByUser");
        ArrayList<Feedback> result = FeedbackDAO.getFeedbackSendedByUser(2);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getFeedbackReceivedByUser method, of class FeedbackDAO.
     */
    @Test
    public void testGetFeedbackReceivedByUser() {
        System.out.println("getFeedbackReceivedByUser");
        ArrayList<Feedback> result = FeedbackDAO.getFeedbackReceivedByUser(2);
        assertTrue("niets gevonden", result.size() > 0);
    }

    /**
     * Test of getLikesOfFeedback & giveLikeToFeedback & removeLikeFromFeedback method, of class FeedbackDAO.
     */
    @Test
    public void testGiveGetRemoveLikeOfFeedback() {
        System.out.println("giveLikeToFeedback");

        assertTrue("give like 1 failed", FeedbackDAO.giveLikeToFeedback(1, 1, true));
        assertTrue("give like 2 failed", FeedbackDAO.giveLikeToFeedback(1, 2, false));

        assertTrue("Less than 2 likes found", FeedbackDAO.getLikesOfFeedback(1).size() >= 2);
        
        assertTrue("remove like failed", FeedbackDAO.removeLikeFromFeedback(1, 1));
        assertTrue("remove like failed", FeedbackDAO.removeLikeFromFeedback(1, 2));
    }

    

    /**
     * Test of getFeedbackRequestSend method, of class FeedbackDAO.
     */
    @Test
    public void testGetFeedbackRequestSend() {
        FeedbackDAO.InsertFeedbackRequest(1, 1);
        ArrayList<FeedbackRequest> a = FeedbackDAO.getFeedbackRequestSend(1);
        assertEquals(1, a.get(0).getIDto());
        assertEquals(1, a.get(0).getIDFrom());
        assertEquals("test test", a.get(0).getNameFrom());
        assertEquals("test test", a.get(0).getNameTo());
    }

    /**
     * Test of getFeedbackRequestRecieved method, of class FeedbackDAO.
     */
    @Test
    public void testGetFeedbackRequestRecieved() {
        FeedbackDAO.InsertFeedbackRequest(1, 1);
        ArrayList<FeedbackRequest> a = FeedbackDAO.getFeedbackRequestRecieved(1);
        assertEquals(1, a.get(0).getIDto());
        assertEquals(1, a.get(0).getIDFrom());
        assertEquals("test test", a.get(0).getNameFrom());
        assertEquals("test test", a.get(0).getNameTo());
    }

}