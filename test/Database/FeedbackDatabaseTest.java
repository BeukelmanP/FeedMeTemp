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
        FeedbackDatabase instance = new FeedbackDatabase();
        ArrayList<Feedback> expResult = null;
        ArrayList<Feedback> result = instance.getAllFeedback();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeedbackSendedReceivedUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedReceivedUser() {
        System.out.println("getFeedbackSendedReceivedUser");
        int userId = 0;
        FeedbackDatabase instance = new FeedbackDatabase();
        ArrayList<Feedback> expResult = null;
        ArrayList<Feedback> result = instance.getFeedbackSendedReceivedUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeedbackSendedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackSendedByUser() {
        System.out.println("getFeedbackSendedByUser");
        int userId = 0;
        FeedbackDatabase instance = new FeedbackDatabase();
        ArrayList<Feedback> expResult = null;
        ArrayList<Feedback> result = instance.getFeedbackSendedByUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeedbackReceivedByUser method, of class FeedbackDatabase.
     */
    @Test
    public void testGetFeedbackReceivedByUser() {
        System.out.println("getFeedbackReceivedByUser");
        int userId = 0;
        ArrayList<Feedback> expResult = null;
        ArrayList<Feedback> result = FeedbackDatabase.getFeedbackReceivedByUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
