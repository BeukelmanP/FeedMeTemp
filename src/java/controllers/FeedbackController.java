/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dal.FeedbackDAO;
import static dal.FeedbackDAO.InsertFeedback;
import static dal.FeedbackDAO.InsertFeedbackRequest;
import java.io.Serializable;
import java.util.ArrayList;
import models.Feedback;
import models.FeedbackRequest;

/**
 *
 * @author Sander
 */
public class FeedbackController implements Serializable {

    private static final long serialVersionUID = 1344828042104158294L;

    String NameUserToGiveFeedback;
    String PictureUserToGiveFeedback;
    String idUserToGiveFeedbackTo;

    private String title;
    private String tips;
    private String tops;
    private String feedback;
    private String profile;
    private int score = 0;

    public String getNameUserToGiveFeedback() {
        return NameUserToGiveFeedback;
    }

    public void setNameUserToGiveFeedback(String NameUserToGiveFeedback) {
        this.NameUserToGiveFeedback = NameUserToGiveFeedback;
    }

    public String getPictureUserToGiveFeedback() {
        return PictureUserToGiveFeedback;
    }

    public void setPictureUserToGiveFeedback(String PictureUserToGiveFeedback) {
        this.PictureUserToGiveFeedback = PictureUserToGiveFeedback;
    }

    public String getIdUserToGiveFeedbackTo() {
        return idUserToGiveFeedbackTo;
    }

    public void setIdUserToGiveFeedbackTo(String idUserToGiveFeedbackTo) {
        this.idUserToGiveFeedbackTo = idUserToGiveFeedbackTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getTops() {
        return tops;
    }

    public void setTops(String tops) {
        this.tops = tops;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String submitFeedback(String sendTo, String sendFrom, boolean goOn) {
        if (!"".equals(title) && !"".equals(feedback) && !"".equals(sendTo) && !"".equals(sendFrom) && goOn) {
            InsertFeedback(Integer.parseInt(sendFrom), Integer.parseInt(sendTo), title, tips, tops, feedback);
            return "searchUser";
        } else {
            return "giveFeedback";
        }
    }

    public ArrayList<FeedbackRequest> getSendRequest() {
        return FeedbackDAO.getFeedbackRequestSend(SessionController.getLoggedInUserStatic().getId());
    }

    public ArrayList<FeedbackRequest> getReceivedRequest() {
        return FeedbackDAO.getFeedbackRequestRecieved(SessionController.getLoggedInUserStatic().getId());
    }

    public ArrayList<Feedback> getUserFeedback() {
        System.out.println("id=: " + idUserToGiveFeedbackTo);
        return FeedbackDAO.getFeedbackReceivedByUser(Integer.parseInt(idUserToGiveFeedbackTo));
    }

    public ArrayList<Feedback> getOwnFeedback() {
        return FeedbackDAO.getFeedbackReceivedByUser(SessionController.getLoggedInUserStatic().getId());
    }

    public String requestFeedback(boolean goOn) {
        if (goOn) {
            System.out.println(idUserToGiveFeedbackTo);
            InsertFeedbackRequest(SessionController.getLoggedInUserStatic().getId(), Integer.parseInt(idUserToGiveFeedbackTo));
        }
        return "requestFeedback";
    }
}
