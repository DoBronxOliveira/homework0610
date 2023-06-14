package service;



import java.util.List;


import DAO.UserDao;
import DAO.UserDaoImpl;
import pojo.User;
import view.AdminView;
import view.UserView;

public class UserServiceImpl implements UserService {

    @Override
    public boolean register(User user) {
        UserDao ud = new UserDaoImpl();
        if (!user.getUsername().equals("")&&!user.getPassword().equals("")&&ud.queryByUsername(user.getUsername()) == null&&ud.addUser(user)) {
//            ud.addUser(user);
            return true;
        }
        return false;
    }



    @Override
    public boolean login(String username, String password) {
        UserDao ud = new UserDaoImpl();
        User u = null;
        if ((u = ud.queryByNameAndPwd(username, password)) != null) {
            System.out.println("登录成功");
            if (u.getAdmin().equals("管理员")) {
                AdminView.show(u);
            } else {
                UserView.show(u);
            }
            return true;
        }
        System.out.println("登录失败，用户名或密码错误");
        return false;
    }

    @Override
    public User userInfo(String username) {
        UserDao ud = new UserDaoImpl();
        User u = ud.queryByUsername(username);
        return u;
    }

    @Override
    public boolean userModify(User user) {
        UserDao ud = new UserDaoImpl();
        if (ud.queryByUsername(user.getUsername()) == null && ud.adminModifyUser(user)) {
            System.out.println("修改成功");
            return true;
        }
        System.out.println("用户名已存在，修改失败");
        return false;
    }

    @Override
    public boolean delUser(int id) {

            UserDao ud = new UserDaoImpl();
            if (ud.queryById(id) != null && ud.delete(id)) {
                return true;
            }
            System.out.println("用户不存在");
            return false;
    }

    @Override
    public boolean adminModifyUser(User user) {
        UserDao ud = new UserDaoImpl();
        if (ud.queryById(user.getId()) != null) {
//            ud.queryByUsername(user.getUsername()) == null &&
            if (ud.adminModifyUser(user)) {
                System.out.println("修改成功");
                return true;
            } else {
                System.out.println("用户名已存在，修改失败");
            }
        } else {
            System.out.println("该id不存在，修改失败");
        }
        return false;

    }

    @Override
    public List<User> adminQueryAll() {
        UserDao ud = new UserDaoImpl();
        List<User> users = ud.queryAll();
        return users;
    }

    @Override
    public User queryById(int id) {
        UserDao ud = new UserDaoImpl();
        User user = ud.queryById(id);
        return user;
    }

    @Override
    public List<User> queryByName(String name) {

        UserDao ud=new UserDaoImpl();
        List<User> users=ud.queryByName(name);
        return users;
    }

}

