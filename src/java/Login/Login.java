/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author piete
 */
public class Login {

    public boolean Authenticate(String email, String password) {
        if ("root".equals(email) && "root".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
