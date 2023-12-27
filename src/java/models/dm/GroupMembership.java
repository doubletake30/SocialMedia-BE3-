/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dm;

/**
 *
 * @author ADMIN
 */
public class GroupMembership {
    private int groupMembershipID;
    private int userID;
    private int groupID;
    private int roleID;

    public GroupMembership(int groupMembershipID, int userID, int groupID, int roleID) {
        this.groupMembershipID = groupMembershipID;
        this.userID = userID;
        this.groupID = groupID;
        this.roleID = roleID;
    }

    public int getGroupMembershipID() {
        return groupMembershipID;
    }

    public void setGroupMembershipID(int groupMembershipID) {
        this.groupMembershipID = groupMembershipID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
    
}
