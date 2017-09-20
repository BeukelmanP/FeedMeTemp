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
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Login.User;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class userData implements Serializable {

    User userLoggedIn = new User(1,"Frederick","the","fred@the.eu","https://pbs.twimg.com/profile_images/3432967857/9b811b619c00d8d32c4f50bac292644f.jpeg","FEO");
    String NameUserToGiveFeedback = "t";
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
        searchedUsers = UserDatabase.searchUser(searchKeyWord);
        searchedUsers.add(new User(1,"Pieter","Beukelman","pieter@beukelman.eu","https://pbs.twimg.com/profile_images/3153805472/8e34159787675b620c6773224d44cc19.jpeg","CEO"));
        searchedUsers.add(new User(1,"Frederick","the","fred@the.eu","https://pbs.twimg.com/profile_images/3432967857/9b811b619c00d8d32c4f50bac292644f.jpeg","FEO"));
        return ("searchUser");
    }

}
