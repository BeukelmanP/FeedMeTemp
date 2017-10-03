/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

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
public class GiveFeedbackTest {
    
    public GiveFeedbackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    GiveFeedback give;
    @Before
    public void setUp() {
        give = new GiveFeedback();
        give.setTitle("testtitle");
        give.setTips("testtips");
        give.setTops("testtops");
        give.setFeedback("testfeedback");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class GiveFeedback.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "testtitle";
        String result = give.getTitle();
        assertEquals(expResult, result);
    }



    /**
     * Test of getTips method, of class GiveFeedback.
     */
    @Test
    public void testGetTips() {
        System.out.println("getTips");
        String expResult = "testtips";
        String result = give.getTips();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTops method, of class GiveFeedback.
     */
    @Test
    public void testGetTops() {
        System.out.println("getTops");
        String expResult = "testtops";
        String result = give.getTops();
        assertEquals(expResult, result);
    }



    /**
     * Test of getFeedback method, of class GiveFeedback.
     */
    @Test
    public void testGetFeedback() {
        System.out.println("getFeedback");
        String expResult = "testfeedback";
        String result = give.getFeedback();
        assertEquals(expResult, result);
    }



    /**
     * Test of getScore method, of class GiveFeedback.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int expResult = 0;
        int result = give.getScore();
        assertEquals(expResult, result);
    }


    /**
     * Test of submitFeedback method, of class GiveFeedback.
     */
    @Test
    public void testSubmitFeedback() {
        System.out.println("submitFeedback");
        String sendTo = "1";
        String sendFrom = "1";
        boolean goOn = false;
        String expResult = "testtitle";
        String result = give.submitFeedback(sendTo, sendFrom, goOn);
        assertEquals(expResult, result);
    }
    
}
