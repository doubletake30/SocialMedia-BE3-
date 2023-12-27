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
public class Post {
    private int postID;
    private String content;
    private Date dateTime;
    private String postType;
    private int userID;
    private Integer groupID; 

    public Post(int postID, String content, Date dateTime, String postType, int userID, Integer groupID) {
        this.postID = postID;
        this.content = content;
        this.dateTime = dateTime;
        this.postType = postType;
        this.userID = userID;
        this.groupID = groupID;
    }

    public Post() {
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
    
    
}
