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
public class Notification {
    private int notificationID;
    private String type;
    private Date dateTime;
    private int senderID;
    private int receiverID;

    public Notification(int notificationID, String type, Date dateTime, int senderID, int receiverID) {
        this.notificationID = notificationID;
        this.type = type;
        this.dateTime = dateTime;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
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

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }
    
    
}
