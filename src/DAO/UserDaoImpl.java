package DAO;

import pojo.User;

import util.DBUtil;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Tan
 * @date 2023/6/10 17:00
 */


public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) {
        String sql = " insert into user(username,password,admin,deptid,jobid) value(?,?,?,?,?) ";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAdmin());
            ps.setInt(4, user.getDeptId());
            ps.setInt(5, user.getJobId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            System.out.println("注册添加失败");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean adminModifyUser(User user) {
        String sql = "update user set username=?,password=?,admin=?,deptid=?,jobid=? where id=?";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAdmin());
            ps.setInt(4, user.getDeptId());
            ps.setInt(5, user.getJobId());
            ps.setInt(6, user.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("修改信息失败");
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public User queryByNameAndPwd(String username, String password) {
        User user = null;
        String sql = " select id,username,password,admin,deptid,jobid from user where username=? and password=?";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("admin"), rs.getInt("deptid"), rs.getInt("jobid"));
            }
            return user;

        } catch (SQLException e) {
            System.out.println("查询失败，密码或用户名错误");
            e.printStackTrace();
        }
        return null;
//
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
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return null;
//
    }

    @Override
    public boolean delete(int id) {

        String sql = "delete from user where id=? ";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return false;
//
    }

    @Override
    public User queryById(int id) {
        String sql = "select * from user where id=?";
        User user = null;
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("admin"), rs.getInt("deptid"), rs.getInt("jobid"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println("查询失败！");
            e.printStackTrace();

        }
        return null;
//
    }

    @Override
    public List<User> queryAll() {
        List<User> users = new ArrayList<>();
        User user = null;
        String sql = "select * from user";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("admin"), rs.getInt("deptid"), rs.getInt("jobid"));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return null;

//
    }

    @Override
    public List<User> queryByName(String name) {
        List<User> users = new ArrayList<>();
        User user = null;
        String sql = "select * from user where username like ?";
        try (
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("admin"), rs.getInt("deptid"), rs.getInt("jobid"));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return null;

//
    }

}


