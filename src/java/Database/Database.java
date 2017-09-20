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

    private java.sql.Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String dbServer;
    private String dbName;
    private String dbUsername;
    private String dbPassword;
    private int dbPort;

    public Database() {
        dbServer = "sql11.freemysqlhosting.net";
        dbName = "sql11194356";
        dbUsername = "sql11194356";
        dbPassword = "YpVPS7iJwE";
        dbPort = 3306;
    }

    /**
     * Connects with the database.
     *
     * @return true if connected, false if failed to connect.
     */
    public boolean connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + dbServer + ":" + dbPort + "/" + dbName;
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("started connection to database...");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to start connection to database...");
            return false;
        }
    }

    public java.sql.Connection getConn() {
        return this.conn;
    }

    /**
     * Closes the connection with the database
     *
     * @return true if the connection is closed, false if it failed.
     */
    public boolean disconnectFromDB() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            System.out.println("Closing connection to database...");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Gets all users from the database.
     *
     * @return ArrayList<User>
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<User>();

        int id;
        String firstname;
        String lastname;
        String email;
        String password;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement("SELECT * FROM user");
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    id = rs.getInt("id");
                    firstname = rs.getString("firstname");
                    lastname = rs.getString("lastname");
                    email = rs.getString("email");
                    password = rs.getString("password");
                    User user = new User(id, firstname, lastname, email, password);
                    result.add(user);
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
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, "", "", "", feedbackContent);
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
     * @param username The username of the user. This typically is the user's email.
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
