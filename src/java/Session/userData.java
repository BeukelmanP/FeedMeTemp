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
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Login.User;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class userData implements Serializable {

    User userLoggedIn = new User(1,"Frederick","the","fred@the.eu","https://pbs.twimg.com/profile_images/3432967857/9b811b619c00d8d32c4f50bac292644f.jpeg","FEO");
    String LoggedInName = "Pieter";

    public User getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public String getLoggedInName() {
        return LoggedInName;
    }

    public void setLoggedInName(String LoggedInName) {
        this.LoggedInName = LoggedInName;
    }
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

    public User getLoggedInUser() {
        return (userLoggedIn);
    }

    public String getNameUserToGiveFeedbackTo() {
        return (NameUserToGiveFeedback);
    }

    public String search() {
        searchedUsers = UserDatabase.searchUser(searchKeyWord);return ("searchUser");
    }

}
