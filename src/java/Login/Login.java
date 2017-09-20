/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Sander
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

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
        //fixdb con
        //boolean valid = Database.validate(username, hashPassword(password);
        User usr = new User(0, "Fred", "The", "f-the@hotmail.com");
        String pw = "Test123";
        
        if (getUsername().equals(usr.getEmail()) && getPassword().equals(pw)) {
            System.out.println("loggedin");
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);
            return "admin";
        } else {
            FacesMessage error = new FacesMessage("Incorrect Username and Password combination!");
            FacesContext.getCurrentInstance().addMessage("loginform:Loginbtn", error);
            return "Index";
        }
    }
    
    public String hashPassword(String password){
        throw new NotImplementedException();
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
}
