package DAO;

import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Tan
 * @date 2023/6/12 20:44
 */
public class EmplyeeDaoImpl implements EmplyeeDao{
    @Override
    public boolean emplyeeModifyUser(User user) {
        String sql = "update user set username=?,password=?,deptid=?,jodid=? where id=?";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getDeptId());
            ps.setInt(4, user.getJobId());
            ps.setInt(5, user.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("修改信息失败");
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public User queryByUsername(String username) {
        User user = null;
        String sql = " select id,username,password,admin,deptid,jobid from user where username=? ";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("admin"), rs.getInt("deptid"), rs.getInt("jobid"));
            }
            return user;

        } catch (SQLException e) {
            System.out.println("没有此用户");
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public User queryItSelf(int id) {
//        User user=null;
//        String sql="select *from user where id=?";
//        try (
//                Connection c=DBUtil.getConnection();
//                PreparedStatement ps=c.prepareStatement(sql)
//                ){
//
//            ps.setInt(1,id);
//            ResultSet rs=ps.executeQuery();
//            while (rs.next()) {
//                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
//                        rs.getString("admin"), rs.getInt("deptid"), rs.getInt("jobid"));
//            }
//            return user;
//
//        }catch (SQLException e){
//            System.out.println("查询失败");
//            e.printStackTrace();
//        }
//        return null;
//    }
}
