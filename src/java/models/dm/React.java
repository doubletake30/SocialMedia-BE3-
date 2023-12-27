/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dm;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class React {
    private int reactionID;
    private String type;
    private Date dateTime;
    private int userID;
    private int postID;

    public React(int reactionID, String type, Date dateTime, int userID, int postID) {
        this.reactionID = reactionID;
        this.type = type;
        this.dateTime = dateTime;
        this.userID = userID;
        this.postID = postID;
    }

    public int getReactionID() {
        return reactionID;
    }

    public void setReactionID(int reactionID) {
        this.reactionID = reactionID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }
    
    
}
