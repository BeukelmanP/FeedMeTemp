/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.SessionUtils;
import models.User;
import dal.UserDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Sander
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1344828042104158293L;

    private String password;
    private String message;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //validate login
    public String validateUsernamePassword() {
         User usr = UserDAO.getUser(username, password);
        
        if (usr != null) {
            System.out.println("loggedin");
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("user", usr);
            return "homePage";
        } else {
            FacesMessage error = new FacesMessage("Incorrect Username and Password combination!");
            FacesContext.getCurrentInstance().addMessage("loginform:Loginbtn", error);
            return "Index";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
}
