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
public class Message {
    private int messageID;
    private String content;
    private Date dateTime;
    private int senderID;
    private int receiverID;

    public Message(int messageID, String content, Date dateTime, int senderID, int receiverID) {
        this.messageID = messageID;
        this.content = content;
        this.dateTime = dateTime;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
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
