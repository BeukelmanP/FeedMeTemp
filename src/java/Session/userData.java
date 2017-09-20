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

@ManagedBean
@SessionScoped
public class userData implements Serializable{
    String LoggedInName="Pieter";
    String NameUserToGiveFeedback="t";
    public String getLoggedInName(){
        return ("Pieter");
    }
    public String getNameUserToGiveFeedbackTo(){
        return (NameUserToGiveFeedback);
    }
    
    
}
