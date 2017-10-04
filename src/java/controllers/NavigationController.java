/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author piete
 */
public class NavigationController {
    public String SearchRequest() {
        return "requestFeedback";
    }
    
    public String visitUser() {
        return ("colleagueProfile");
    }
    public String search() {
        return ("searchUser");
    }
    
    public String GiveFeedback() {
        return "giveFeedback";

    }
}
