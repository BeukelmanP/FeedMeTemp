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
import Database.FeedbackDatabase;
import static Database.FeedbackDatabase.InsertFeedbackRequest;
import Database.UserDatabase;
import Feedback.Feedback;
import Feedback.FeedbackRequest;
import Login.SessionUtils;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Login.User;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class userData implements Serializable {

    User userLoggedIn = getUserAccount();
    User userToVisit;

    public User getUserAccount() {
        HttpSession session = SessionUtils.getSession();
        return (User) session.getAttribute("user");
    }

    public User getUserToVisit() {
        return userToVisit;
    }

    public void setUserToVisit(User userToVisit) {
        this.userToVisit = userToVisit;
    }

    public User getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
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
    String searchRequestKeyWord;

    public String getSearchRequestKeyWord() {
        return searchRequestKeyWord;
    }

    public void setSearchRequestKeyWord(String searchRequestKeyWord) {
        this.searchRequestKeyWord = searchRequestKeyWord;
    }
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
        return ("searchUser");
    }

    public ArrayList<User> searchUser() {
        return UserDatabase.searchUser(searchKeyWord);
    }

    public ArrayList<User> searchUserRequest() {
        return UserDatabase.searchUser(searchRequestKeyWord);
    }

    public String visitUser() {
        userToVisit = UserDatabase.getUser(Integer.parseInt(idUserToGiveFeedbackTo));
        return ("colleagueProfile");
    }

    public ArrayList<Feedback> getUserFeedback() {
        return FeedbackDatabase.getFeedbackReceivedByUser(Integer.parseInt(idUserToGiveFeedbackTo));
    }

    public ArrayList<Feedback> getOwnFeedback() {
        return FeedbackDatabase.getFeedbackReceivedByUser(userLoggedIn.getId());
    }

    public String SearchRequest() {
        return "requestFeedback";
    }

    public String requestFeedback(boolean goOn) {
        if (goOn) {
            System.out.println(idUserToGiveFeedbackTo);
            InsertFeedbackRequest(userLoggedIn.getId(), Integer.parseInt(idUserToGiveFeedbackTo));
        }
        return "requestFeedback";
    }

    public ArrayList<FeedbackRequest> getSendRequest() {
        return FeedbackDatabase.getFeedbackRequestSend(userLoggedIn.getId());
    }

    public ArrayList<FeedbackRequest> getReceivedRequest() {
        return FeedbackDatabase.getFeedbackRequestRecieved(userLoggedIn.getId());
    }

}
