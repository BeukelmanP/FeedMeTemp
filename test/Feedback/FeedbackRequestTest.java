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
public class FeedbackRequestTest {

    public FeedbackRequestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    FeedbackRequest a;

    @Before
    public void setUp() {
        a = new FeedbackRequest(1, 2, "a", "b", "c", "d");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getImageTo method, of class FeedbackRequest.
     */
    @Test
    public void testGetImageTo() {
        System.out.println("getImageTo");
        String expResult = "d";
        String result = a.getImageTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImageFrom method, of class FeedbackRequest.
     */
    @Test
    public void testGetImageFrom() {
        System.out.println("getImageFrom");
        String expResult = "c";
        String result = a.getImageFrom();
        assertEquals(expResult, result);
    }


    /**
     * Test of getIDto method, of class FeedbackRequest.
     */
    @Test
    public void testGetIDto() {
        System.out.println("getIDto");
        int expResult = 2;
        int result = a.getIDto();
        assertEquals(expResult, result);
    }


    /**
     * Test of getIDFrom method, of class FeedbackRequest.
     */
    @Test
    public void testGetIDFrom() {
        System.out.println("getIDFrom");
        int expResult = 1;
        int result = a.getIDFrom();
        assertEquals(expResult, result);
    }


    /**
     * Test of getNameTo method, of class FeedbackRequest.
     */
    @Test
    public void testGetNameTo() {
        System.out.println("getNameTo");
        String expResult = "b";
        String result = a.getNameTo();
        assertEquals(expResult, result);
    }


    /**
     * Test of getNameFrom method, of class FeedbackRequest.
     */
    @Test
    public void testGetNameFrom() {
        System.out.println("getNameFrom");
        String expResult = "a";
        String result = a.getNameFrom();
        assertEquals(expResult, result);
    }


}
