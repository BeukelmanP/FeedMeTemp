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
import dal.UserDAO;
import java.io.Serializable;
import java.util.ArrayList;
import models.User;

public class UserdataController implements Serializable {

    String idUserToVisit;
    String searchKeyWord;
    String searchRequestKeyWord;

    public String getIdUserToVisit() {
        return idUserToVisit;
    }

    public void setIdUserToVisit(String idUserToVisit) {
        this.idUserToVisit = idUserToVisit;
    }

    
    public String getSearchRequestKeyWord() {
        return searchRequestKeyWord;
    }

    public void setSearchRequestKeyWord(String searchRequestKeyWord) {
        this.searchRequestKeyWord = searchRequestKeyWord;
    }

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public ArrayList<User> searchUser() {
        return UserDAO.searchUser(searchKeyWord);
    }

    public ArrayList<User> searchUserRequest() {
        return UserDAO.searchUser(searchRequestKeyWord);
    }

    public User getVisitedUser() {
        return UserDAO.getUser(Integer.parseInt(idUserToVisit));
    }

}
