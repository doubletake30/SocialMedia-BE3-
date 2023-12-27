/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import models.dm.React;
import utils.JDBCUtil;

/**
 *
 * @author ADMIN
 */
public class ReactDAO implements I_DAO<React> {
    public static ReactDAO getInstance() {
        return new ReactDAO();
    }

    @Override
    public int insert(React react) {
        
        int res = 0;
        try {
            
            Connection con = JDBCUtil.getConnection();
            
            String sql = "INSERT INTO likepost(LikeId, likeDATE, likeTIME, PostId, UserId)"
                    + "VALUES (MD5(UUID()), ?, ?, ?, ?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, React.getLikeDate());
            pst.setTime(2, React.getLikeTime());
            pst.setString(3, React.getPostId());
            pst.setString(4, React.getUserId());
            
            res = pst.executeUpdate();
            
            JDBCUtil.closeConnection(con);
            
        } catch(Exception e) {
            
        }
        return res;
        
    }

    @Override
    public int update(Like t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Like like) {
        
        int res = 0;
        try {
            
            Connection con = JDBCUtil.getConnection();
            
            String sql = "DELETE FROM likepost WHERE LikeId = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, like.getLikeId());
            
            res = pst.executeUpdate();
            
            JDBCUtil.closeConnection(con);
            
        } catch(Exception e) {
            
        }
        return res;
        
    }
    
    public int deleteByPostId(String postId) {
        
        int res = 0;
        try {
            
            Connection con = JDBCUtil.getConnection();
            
            String sql = "DELETE FROM likepost WHERE PostId = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, postId);
            
            res = pst.executeUpdate();
            
            JDBCUtil.closeConnection(con);
            
        } catch(Exception e) {
            
        }
        return res;
        
    }

    @Override
    public ArrayList<Like> selectAll() {

        ArrayList<Like> res = new ArrayList<>();
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM likepost";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("LikeId");
                Date likeDate = rs.getDate("likeDATE");
                Time likeTime = rs.getTime("likeTIME");
                String postId = rs.getString("PostId");
                String UserId = rs.getString("UserId");

                Like like = new Like(id, likeDate, likeTime, postId, UserId);

                res.add(like);
            }
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {

        }
        return res;

    }

    @Override
    public Like selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Like> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Like checkLikeStatus(String userId, String postId) {

        Like res = null;
        ArrayList<Like> check = selectAll();
        for (Like like : check) {
            if (userId.equals(like.getUserId()) && postId.equals(like.getPostId())) {
                res = like;
            }
        }
        return res;
        
    }
    
    public int countLike(String postId) {
        
        ArrayList<Like> check = selectAll();
        int count = 0;
        for (Like like : check) {
            if (postId.equals(Util.encryptPassword(like.getPostId()))) {
                count++;
            }
        }
        return count;
        
    }
}
