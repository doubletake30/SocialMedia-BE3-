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
public class Comment {
    private int commentID;
    private String content;
    private Date dateTime;
    private int userID;
    private int postID;

    public Comment(int commentID, String content, Date dateTime, int userID, int postID) {
        this.commentID = commentID;
        this.content = content;
        this.dateTime = dateTime;
        this.userID = userID;
        this.postID = postID;
    }
    

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
