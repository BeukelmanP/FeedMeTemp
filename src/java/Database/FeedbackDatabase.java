/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Database.getConnection;
import Feedback.Feedback;
import Feedback.FeedbackRequest;
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

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback")) {
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int sendTo = rs.getInt("sendTo");
                    int sendFrom = rs.getInt("sendFrom");
                    String feedbackTitle = rs.getString("title");
                    String feedbackTips = rs.getString("tips");
                    String feedbackTops = rs.getString("tops");
                    String feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackTitle, feedbackTips, feedbackTops, feedbackContent);
                    feedback = FeedbackDatabase.FeedbackWithLikes(feedback);
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
    public static ArrayList<Feedback> getFeedbackSendedReceivedUser(int userId) {
        ArrayList<Feedback> result = new ArrayList<Feedback>();

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE sendTo = ? OR sendFrom = ? ORDER BY timeCreated DESC")) {
                pstmt.setInt(1, userId);
                pstmt.setInt(2, userId);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int sendTo = rs.getInt("sendTo");
                    int sendFrom = rs.getInt("sendFrom");
                    String feedbackTitle = rs.getString("title");
                    String feedbackTips = rs.getString("tips");
                    String feedbackTops = rs.getString("tops");
                    String feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackTitle, feedbackTips, feedbackTops, feedbackContent);
                    feedback = FeedbackDatabase.FeedbackWithLikes(feedback);
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
    public static ArrayList<Feedback> getFeedbackSendedByUser(int userId) {
        ArrayList<Feedback> result = new ArrayList<Feedback>();

        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE sendFrom = ? ORDER BY timeCreated DESC")) {
                pstmt.setInt(1, userId);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int sendTo = rs.getInt("sendTo");
                    int sendFrom = rs.getInt("sendFrom");
                    String feedbackTitle = rs.getString("title");
                    String feedbackTips = rs.getString("tips");
                    String feedbackTops = rs.getString("tops");
                    String feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackTitle, feedbackTips, feedbackTops, feedbackContent);
                    feedback = FeedbackDatabase.FeedbackWithLikes(feedback);
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
    public static ArrayList<Feedback> getFeedbackReceivedByUser(int userId) {
        ArrayList<Feedback> result = new ArrayList<Feedback>();
        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;
            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback WHERE sendTo = ? ORDER BY timeCreated DESC")) {
                pstmt.setInt(1, userId);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int sendTo = rs.getInt("sendTo");
                    int sendFrom = rs.getInt("sendFrom");
                    String feedbackTitle = rs.getString("title");
                    String feedbackTips = rs.getString("tips");
                    String feedbackTops = rs.getString("tops");
                    String feedbackContent = rs.getString("feedback");
                    Feedback feedback = new Feedback(id, sendTo, sendFrom, feedbackTitle, feedbackTips, feedbackTops, feedbackContent);
                    feedback = FeedbackDatabase.FeedbackWithLikes(feedback);
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
    private static Feedback FeedbackWithLikes(Feedback feedback) {
        Feedback result = feedback;

        //add the likes to the feedback
        Map<Integer, Boolean> likesOfFeedback = FeedbackDatabase.getLikesOfFeedback(result.getId());
        for (Map.Entry<Integer, Boolean> entry : likesOfFeedback.entrySet()) {
            Integer key = entry.getKey();
            Boolean value = entry.getValue();
            result.likeFeedback(key, value);
        }

        return result;
    }

    public static ArrayList<FeedbackRequest> getFeedbackRequestSend(int userId) {
        ArrayList<FeedbackRequest> result = new ArrayList<FeedbackRequest>();
        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;
            try (PreparedStatement pstmt = con.prepareStatement("Select u1.firstname as 'user1first', u1.lastname as 'user1last',u1.image as 'user1image', u2.firstname as 'user2first',u2.lastname as 'user2last',u2.image as 'user2image', rf.sendFrom, rf.sendTo From user u1, user u2, request_feedback rf Where u1.id = rf.sendFrom AND u2.id = rf.sendTo AND sendFrom=?;")) {
                pstmt.setInt(1, userId);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    String nameFrom = rs.getString("user1first") + " " + rs.getString("user1last");
                    String nameTo = rs.getString("user2first") + " " + rs.getString("user2last");
                    int idFrom = rs.getInt("sendFrom");
                    int idTo = rs.getInt("sendTo");
                    String imageFrom = rs.getString("user1image");
                    String imageTo = rs.getString("user2image");
                    FeedbackRequest req = new FeedbackRequest(idFrom, idTo, nameFrom, nameTo, imageFrom, imageTo);
                    result.add(req);
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

    public static ArrayList<FeedbackRequest> getFeedbackRequestRecieved(int userId) {
        ArrayList<FeedbackRequest> result = new ArrayList<FeedbackRequest>();
        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;
            try (PreparedStatement pstmt = con.prepareStatement("Select u1.firstname as 'user1first', u1.lastname as 'user1last',u1.image as 'user1image', u2.firstname as 'user2first',u2.lastname as 'user2last',u2.image as 'user2image', rf.sendFrom, rf.sendTo From user u1, user u2, request_feedback rf Where u1.id = rf.sendFrom AND u2.id = rf.sendTo AND sendTo=?;")) {
                pstmt.setInt(1, userId);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    String nameFrom = rs.getString("user1first") + " " + rs.getString("user1last");
                    String nameTo = rs.getString("user2first") + " " + rs.getString("user2last");
                    int idFrom = rs.getInt("sendFrom");
                    int idTo = rs.getInt("sendTo");
                    String imageFrom = rs.getString("user1image");
                    String imageTo = rs.getString("user2image");
                    FeedbackRequest req = new FeedbackRequest(idFrom, idTo, nameFrom, nameTo, imageFrom, imageTo);
                    result.add(req);
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

    public static void InsertFeedbackRequest(int from, int to) {
        Connection con = null;

        try {
            con = getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO request_feedback (`sendFrom`, `sendTo`) VALUES (?, ?);")) {
                pstmt.setInt(1, from);
                pstmt.setInt(2, to);
                pstmt.executeUpdate();
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
    }

    public static void InsertFeedback(int from, int to, String title, String tips, String tops, String feedback) {
        Connection con = null;
        try {
            con = getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO feedback (sendTo, sendFrom, title, tips, tops, feedback, timeCreated) VALUES (?,?,?,?,?,?, CURRENT_TIMESTAMP);")) {
                pstmt.setInt(1, to);
                pstmt.setInt(2, from);
                pstmt.setString(3, title);
                pstmt.setString(4, tips);
                pstmt.setString(5, tops);
                pstmt.setString(6, feedback);
                pstmt.executeUpdate();
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
    }

    public static int Score(int userId) {
        int score = 0;
        Connection con = null;

        try {
            con = getConnection();
            ResultSet rs;

            try (PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(id) AS Score FROM feedback WHERE sendFrom = ?")) {
                pstmt.setInt(1, userId);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    score = rs.getInt("Score");
                }
            }

            try (PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) AS Score FROM user_feedback WHERE feedbackId IN (SELECT id FROM feedback WHERE sendFrom = ?) AND helpful = 1")) {
                pstmt.setInt(1, userId);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    score = score + rs.getInt("Score");
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
        return score;
    }

}
