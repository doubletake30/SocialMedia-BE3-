/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dm;

/**
 *
 * @author ADMIN
 */
public class Friendship {
    private int friendshipID;
    private int userID1;
    private int userID2;
    private String status;

    public Friendship(int friendshipID, int userID1, int userID2, String status) {
        this.friendshipID = friendshipID;
        this.userID1 = userID1;
        this.userID2 = userID2;
        this.status = status;
    }

    public int getFriendshipID() {
        return friendshipID;
    }

    public void setFriendshipID(int friendshipID) {
        this.friendshipID = friendshipID;
    }

    public int getUserID1() {
        return userID1;
    }

    public void setUserID1(int userID1) {
        this.userID1 = userID1;
    }

    public int getUserID2() {
        return userID2;
    }

    public void setUserID2(int userID2) {
        this.userID2 = userID2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
