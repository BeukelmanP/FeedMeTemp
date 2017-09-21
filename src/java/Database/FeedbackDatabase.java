/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Database.getConnection;
import Feedback.Feedback;
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
public class FeedbackDatabase extends Database {

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

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback")) {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    result.add(feedback);
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
     * gets all feedback related to user ordered by timeCreated from the database DESC
     *
     * @return ArrayList<Feedback>
     */
    public ArrayList<Feedback> getFeedbackSendedReceivedUser(int id) {
        ArrayList<Feedback> result = new ArrayList<Feedback>();
        int sendTo;
        int sendFrom;
        String feedbackContent;

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE sendTo = ? OR sendFrom = ? ORDER BY timeCreated DESC")) {
                pstmt.setInt(1, id);
                pstmt.setInt(2, id);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    result.add(feedback);
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
     * gets all feedback sended by the user ordered by timeCreated from the database DESC
     *
     * @return ArrayList<Feedback>
     */
    public ArrayList<Feedback> getFeedbackSendedByUser(int id) {
        ArrayList<Feedback> result = new ArrayList<Feedback>();
        int sendTo;
        int sendFrom;
        String feedbackContent;

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE sendFrom = ? ORDER BY timeCreated DESC")) {
                pstmt.setInt(1, id);
                pstmt.setInt(2, id);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    result.add(feedback);
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
     * gets all feedback sended to user ordered by timeCreated from the database DESC
     *
     * @return ArrayList<Feedback>
     */
    public ArrayList<Feedback> getFeedbackReceivedByUser(int id) {
        ArrayList<Feedback> result = new ArrayList<Feedback>();
        int sendTo;
        int sendFrom;
        String feedbackContent;

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE sendTo = ? ORDER BY timeCreated DESC")) {
                pstmt.setInt(1, id);
                pstmt.setInt(2, id);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    result.add(feedback);
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
}