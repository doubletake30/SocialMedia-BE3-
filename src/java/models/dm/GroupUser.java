/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dm;

/**
 *
 * @author ADMIN
 */
public class GroupUser {
    private int groupID;
    private String name;
    private String description;
    private int ownerID;

    public GroupUser(int groupID, String name, String description, int ownerID) {
        this.groupID = groupID;
        this.name = name;
        this.description = description;
        this.ownerID = ownerID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    
}
