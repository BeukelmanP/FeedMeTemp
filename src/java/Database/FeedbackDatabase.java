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
import java.util.HashMap;
import java.util.Map;
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
    public static ArrayList<Feedback> getAllFeedback() {
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
                    feedback = new FeedbackDatabase().FeedbackWithLikes(feedback);
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
     * gets all feedback related to user ordered by timeCreated from the
     * database DESC
     *
     * @return ArrayList<Feedback>
     */
    public static ArrayList<Feedback> getFeedbackSendedReceivedUser(int id) {
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
                    feedback = new FeedbackDatabase().FeedbackWithLikes(feedback);

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
     * gets all feedback sended by the user ordered by timeCreated from the
     * database DESC
     *
     * @return ArrayList<Feedback>
     */
    public static ArrayList<Feedback> getFeedbackSendedByUser(int id) {
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

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    feedback = new FeedbackDatabase().FeedbackWithLikes(feedback);
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
     * gets all feedback sended to user ordered by timeCreated from the database
     * DESC
     *
     * @return ArrayList<Feedback>
     */
    public static ArrayList<Feedback> getFeedbackReceivedByUser(int id) {
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

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                    sendTo = rs.getInt("sendTo");
                    sendFrom = rs.getInt("sendFrom");
                    feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackContent);
                    feedback = new FeedbackDatabase().FeedbackWithLikes(feedback);
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
     * gets all (dis)likes of a feedback-object from the database.
     *
     * @param feedbackID
     * @return
     */
    public static Map<Integer, Boolean> getLikesOfFeedback(Integer feedbackID) {
        Map<Integer, Boolean> result = new HashMap<Integer, Boolean>();

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user_feedback WHERE feedbackId = ?")) {
                pstmt.setInt(1, feedbackID);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Integer likeFrom = rs.getInt("likeFrom");
                    Boolean helpful = rs.getBoolean("helpful");
                    result.put(likeFrom, helpful);
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
     * uploads (dis)like to the database.
     *
     * @param feedbackId id of feedback that receives the (dis)like
     * @param likeFrom feedbackGiver's id
     * @param helpful helpful or not helpful?
     * @return
     */
    public static Boolean giveLikeToFeedback(Integer feedbackId, Integer likeFrom, Boolean helpful) {
        Boolean result = false;

        Connection con = null;

        try {
            con = getConnection();

            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO user_feedback(feedbackId, likeFrom, helpful) VALUES(?, ?, ?)")) {
                pstmt.setInt(1, feedbackId);
                pstmt.setInt(2, likeFrom);
                pstmt.setBoolean(3, helpful);

                if (pstmt.executeUpdate() > 0) {
                    result = true;
                }
            }
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
     * removes (dis)like of feedback from the database.
     *
     * @param feedbackId
     * @param likeFrom
     * @return
     */
    public static Boolean removeLikeFromFeedback(Integer feedbackId, Integer likeFrom) {
        Boolean result = false;

        Connection con = null;

        try {
            con = getConnection();

            try (PreparedStatement pstmt = con.prepareStatement("DELETE FROM user_feedback WHERE feedbackId = ? AND likeFrom = ?")) {
                pstmt.setInt(1, feedbackId);
                pstmt.setInt(2, likeFrom);

                if (pstmt.executeUpdate() > 0) {
                    result = true;
                }
            }
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
     * adds likes to a feedback-object
     *
     * @param feedback
     * @return
     */
    private Feedback FeedbackWithLikes(Feedback feedback) {
        Feedback result = feedback;

        //add the likes to the feedback
        Map<Integer, Boolean> likesOfFeedback = this.getLikesOfFeedback(result.getId());
        for (Map.Entry<Integer, Boolean> entry : likesOfFeedback.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            result.likeFeedback(key, value);
        }

        return result;
    }

}
