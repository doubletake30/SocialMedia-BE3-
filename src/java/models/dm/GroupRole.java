/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dm;

/**
 *
 * @author ADMIN
 */
public class GroupRole {
    private int groupRoleID;
    private String roleName;

    public GroupRole(int groupRoleID, String roleName) {
        this.groupRoleID = groupRoleID;
        this.roleName = roleName;
    }

    public int getGroupRoleID() {
        return groupRoleID;
    }

    public void setGroupRoleID(int groupRoleID) {
        this.groupRoleID = groupRoleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
}
