/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import static dal.Database.getConnection;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gebruiker
 */
public class UserDAO extends Database {

    /**
     * Gets all users from the database. -------------------
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
                    User user = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("image"), rs.getString("department"));
                    result.add(user);
                }
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public static ArrayList<User> searchUser(String keyword) {
        ArrayList<User> result = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE firstname LIKE ? OR lastname LIKE ? OR firstname LIKE ? AND lastname LIKE ? ")) {
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + keyword + "%");
                pstmt.setString(3, "%" + keyword + "%");
                pstmt.setString(4, "%" + keyword + "%");
                rs = pstmt.executeQuery();
                while (rs.next()) {

                    User user = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("image"), rs.getString("department"));
                    result.add(user);
                }
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
     * Get a user from the database.
     *
     * @param username The username of the user. This typically is the user's
     * email.
     * @param password The password of the user.
     * @return User with the given username and password
     */
    public static User getUser(String username, String password) {
        User result = null;
        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            if (!username.isEmpty() && !password.isEmpty()) {
                try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE email = ? and BINARY password = ?")) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);

                    rs = pstmt.executeQuery();
                    rs.next();
                    int id = rs.getInt("id");
                    int score = FeedbackDAO.Score(id);
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String picture = rs.getString("image");
                    String department = rs.getString("department");

                    result = new User(id, firstname, lastname, email, picture, department, score);
                    rs.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger("User not found");
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public static User getUser(int id) {
        User result = null;
        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            if (id != 0) {
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE id = ?");
                pstmt.setInt(1, id);

                rs = pstmt.executeQuery();
                rs.next();
                id = rs.getInt("id");
                int score = FeedbackDAO.Score(id);
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String picture = rs.getString("image");
                String department = rs.getString("department");
                result = new User(id, firstname, lastname, email, picture, department, score);
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("User not found");
            System.out.println(ex.getMessage());
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
}
