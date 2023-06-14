package service;

import pojo.User;

import java.util.List;

/**
 * @author Tan
 * @date 2023/6/12 12:31
 */
public interface UserService {


    boolean register(User u);

    boolean login(String username, String pwd);

    User userInfo(String username);

    boolean userModify(User user);

    boolean delUser(int id);

    boolean adminModifyUser(User u);

    List<User> adminQueryAll();

    User queryById(int id);


    List<User> queryByName(String name);

}



