package DAO;

import pojo.User;

/**
 * @author Tan
 * @date 2023/6/12 20:42
 */
public interface EmplyeeDao {
    /**
     * @param user
     * @return
     */
    boolean emplyeeModifyUser(User user);

    /**
     * @param username
     * @return
     */
    User queryByUsername(String username);

//    User queryItSelf(int id);



}
