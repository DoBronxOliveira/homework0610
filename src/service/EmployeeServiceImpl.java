package service;

import DAO.EmplyeeDao;
import DAO.EmplyeeDaoImpl;
import DAO.UserDao;
import DAO.UserDaoImpl;
import pojo.User;

/**
 * @author Tan
 * @date 2023/6/12 20:52
 */
public class EmployeeServiceImpl implements EmplyeeService {
    @Override
    public boolean userModify(User user) {
        EmplyeeDao ed = new EmplyeeDaoImpl();
        if (ed.queryByUsername(user.getUsername()) != null) {
            ed.emplyeeModifyUser(user);
            System.out.println("修改成功");
            return true;
        }
        System.out.println("用户名已存在，修改失败");
        return false;
    }

   /* @Override
    public User queryItSelf(int id) {
        EmplyeeDao ed = new EmplyeeDaoImpl();
        User user=ed.queryItSelf(id);
        return user;
    }*/
}
