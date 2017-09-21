/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam Dirkx
 */
public class Feedback {
    private int id;
    private int sendTo;
    private int sendFrom;
    private String title;
    private String tips;
    private String tops;
    private String feedback;
    
    private Map<Integer,Boolean> user_feedback;
    
    public Map<Integer,Boolean> user_feedback()
    {
        return user_feedback;
    }

    public int getId() {
        return id;
    }

    public int getSendTo() {
        return sendTo;
    }

    public int getSendFrom() {
        return sendFrom; 
    }

    public String getFeedback() {
        return feedback;
    }

    public Feedback(int id, int sendTo, int sendFrom, String title, String tips, String tops, String feedback) {
        this.id = id;
        this.sendTo = sendTo;
        this.sendFrom = sendFrom;
        this.title = title;
        this.tips = tips;
        this.tops = tops;
        this.feedback = feedback;
        user_feedback = new HashMap<Integer,Boolean>();
    }

    /**
     * adds a like to this feedback.
     * @param id The id of the user that (dis)liked the feedback
     * @param helpful Whether the feedback was helpfull or not. (similiar to like/dislike)
     */
    public void likeFeedback(Integer id, Boolean helpful)
    {
        user_feedback.put(id, helpful);
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", sendTo=" + sendTo + ", sendFrom=" + sendFrom + ", title=" + title + ", tips=" + tips + ", tops=" + tops + ", feedback=" + feedback + "}";
    }
}
