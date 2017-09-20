/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Feedback.Feedback;
import Login.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//test comment blabla merging shit
/**
 *
 * @author wesle
 */
public class Database {

    /**
     * Connects with the database.
     *
     * @return true if connected, false if failed to connect.
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11194356";
        return DriverManager.getConnection(url, "sql11194356", "YpVPS7iJwE");
    }

    /**
     * Gets all users from the database.
     *
     * @return ArrayList<User>
     */
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        Connection con = null;
        
        try {
            con = getConnection();
            ResultSet rs;
            
            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user")) {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    User user = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"));
                    result.add(user);
                }
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("connection isnt closed but cant close");
                }
            }
        }
        return result;
    }

    /**
     * gets all feedback from the database
     *
     * @return ArrayList<Feedback>
     */
    public ArrayList<Feedback> getAllFeedback() {
        ArrayList<Feedback> result = new ArrayList<Feedback>();
        int id;
        int sendTo;
        int sendFrom;
        String feedbackContent;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement("SELECT * FROM user");
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    result.add(feedback);
                }
                pstmt.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("There is no existing connection");
        }

        return result;
    }

    /**
     * Get a user from the database.
     *
     * @param username The username of the user. This typically is the user's
     * email.
     * @param password The password of the user.
     * @return User with the given username and password
     */
    public User getUser(String username, String password) {
        User result = null;

        int id;
        String firstname;
        String lastname;
        String email;

        if (!username.isEmpty() && !password.isEmpty()) {
            try {
                pstmt = conn.prepareStatement("SELECT * FROM user WHERE BINARY email = ? and BINARY password = ?");
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                rs = pstmt.executeQuery();
                rs.next();
                id = rs.getInt("id");
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                email = rs.getString("email");
                password = rs.getString("password");
                result = new User(id, firstname, lastname, email, password);

                pstmt.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger("User not found");
                System.out.println(ex.getMessage());
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Username and password may not be empty.");
        }
        return result;
    }
}
