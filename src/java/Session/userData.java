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
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class userData implements Serializable{
    String LoggedInName="Pieter";
    String NameUserToGiveFeedback;
    public String getLoggedInName(){
        return (LoggedInName);
    }
    public String getNameUserToGiveFeedbackTo(){
        return (NameUserToGiveFeedback);
    }
    
    
}
