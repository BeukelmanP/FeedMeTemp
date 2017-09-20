/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

/**
 *
 * @author piete
 */
import Database.UserDatabase;
import Login.User;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class userData implements Serializable {

    String LoggedInName = "Pieter";
    String NameUserToGiveFeedback;
    String PictureUserToGiveFeedback;
    String idUserToGiveFeedbackTo;

    public String getIdUserToGiveFeedbackTo() {
        return idUserToGiveFeedbackTo;
    }

    public void setIdUserToGiveFeedbackTo(String idUserToGiveFeedbackTo) {
        this.idUserToGiveFeedbackTo = idUserToGiveFeedbackTo;
    }

    public String getNameUserToGiveFeedback() {
        return NameUserToGiveFeedback;
    }

    public void setNameUserToGiveFeedback(String NameUserToGiveFeedback) {
        this.NameUserToGiveFeedback = NameUserToGiveFeedback;
    }

    public String getPictureUserToGiveFeedback() {
        return PictureUserToGiveFeedback;
    }

    public void setPictureUserToGiveFeedback(String PictureUserToGiveFeedback) {
        this.PictureUserToGiveFeedback = PictureUserToGiveFeedback;
    }

    public String setGiveFeedback() {
        //name;picture;id
        return "giveFeedback";
        
    }
    //@ManagedProperty(value = "#{searchKeyWord}")
    String searchKeyWord;
    ArrayList<User> searchedUsers;

    public ArrayList<User> getSearchedUsers() {
        return searchedUsers;
    }

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public String getLoggedInName() {
        return ("Pieter");
    }

    public String getNameUserToGiveFeedbackTo() {
        return (NameUserToGiveFeedback);
    }

    public String search() {
        searchedUsers = UserDatabase.searchUser(searchKeyWord);return ("searchUser");
    }

}
