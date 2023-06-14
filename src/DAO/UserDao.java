package DAO;

import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tan
 * @date 2023/6/12 12:44
 */
public interface UserDao {


    /**
     * @param user
     * @return
     */
    boolean addUser(User user);


    /**
     * @param user
     * @return
     */
    boolean adminModifyUser(User user);


    User queryByNameAndPwd(String username, String password);


    User queryByUsername(String username);


    boolean delete(int id);


    User queryById(int id);


    List<User> queryAll();


    List<User> queryByName(String name);

}

