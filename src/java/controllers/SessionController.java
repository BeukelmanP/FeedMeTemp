/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import models.SessionUtils;
import models.User;

/**
 *
 * @author piete
 */
@ManagedBean(name = "SessionController", eager = true)
@SessionScoped
public class SessionController implements Serializable {

    public UserdataController userdataController = new UserdataController();
    public LoginController loginController = new LoginController();
    public FeedbackController feedbackController = new FeedbackController();
    public NavigationController navigationController = new NavigationController();
    public static User loggedInUser;

    public User getLoggedInUser() {
        if (loggedInUser == null) {
            loggedInUser = getUserAccount();
        }
        return loggedInUser;
    }

    public static User getLoggedInUserStatic() {
        if (loggedInUser == null) {
            loggedInUser = getUserAccount();
        }
        return loggedInUser;
    }

    public static User getUserAccount() {
        HttpSession session = SessionUtils.getSession();
        return (User) session.getAttribute("user");
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }

    public UserdataController getUserdataController() {
        return userdataController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public FeedbackController getFeedbackController() {
        return feedbackController;
    }

}
