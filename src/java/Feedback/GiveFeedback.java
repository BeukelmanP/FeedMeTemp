/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

import static Database.FeedbackDatabase.InsertFeedback;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Sander
 */
@ManagedBean
//@SessionScoped
public class GiveFeedback implements Serializable {

    private static final long serialVersionUID = 1344828042104158294L;

    private String title;
    private String tips;
    private String tops;
    private String feedback;

    private String profile;

    private int score = 0;

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
        if (!"".equals(title) && !"".equals(feedback) && goOn) {
            InsertFeedback(Integer.parseInt(sendFrom), Integer.parseInt(sendTo), title, tips, tops, feedback);
            return "searchUser";
        } else {
            return "giveFeedback";
        }
    }
}
