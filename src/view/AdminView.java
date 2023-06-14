package view;


import pojo.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tan
 * @date 2023/6/12 16:36
 */
public class AdminView {
    static Scanner sc = new Scanner(System.in);

    //管理员主界面
    public static void show(User user) {
        System.out.println("欢迎登录到管理员主界面");
        System.out.println(user.getUsername() + "您好，您的权限是管理员");

        while (true) {
            System.out.println("==========================");
            System.out.println("请选择功能");
            System.out.println("添加用户--------------1");
            System.out.println("删除用户--------------2");
            System.out.println("修改用户--------------3");
            System.out.println("查询用户--------------4");
            System.out.println("返回上一级------------5");
            String option = sc.nextLine();
            switch (option) {
                case "1":
//                    AdminView.adminAddUserShow();
                    adminAddUserShow();
                    break;
                case "2":
                    delUserShow();
                    break;
                case "3":
                    adminModifyUserShow();
                    break;
                case "4":
                    adminQueryUserShow();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("请重新输入！");
                    break;
            }
        }
    }

    //添加用户界面
    public static void adminAddUserShow() {
        System.out.println("==========================");
        System.out.println("用户添加界面");
        System.out.println("==========================");
        System.out.println("请输入要添加的用户名username");
        String username = sc.nextLine();
        System.out.println("请输入要输入的密码");
        String password = sc.nextLine();
        System.out.println("请输入部门号");
//        int deptId = sc.nextLine();?????????????????
        int deptId = Integer.parseInt(sc.nextLine());
        System.out.println("请输入职位号");
//        int jobId = sc.nextLine();???????????????????
        int jobId = Integer.parseInt(sc.nextLine());
        User user = new User(username, password, "用户", deptId, jobId);
        UserService us = new UserServiceImpl();
        if (us.register(user)) {
            System.out.println("用户添加成功");
        } else {
            System.out.println("用户已存在或为空，添加失败");
        }
        return;
    }

    //删除用户界面
    public static void delUserShow() {
        System.out.println("==========================");
        System.out.println("用户删除界面");
        System.out.println("==========================");
        System.out.println("请输入要删除的用户id");
        int ID = Integer.parseInt(sc.nextLine());
        UserService us = new UserServiceImpl();
//        us.delUser(ID);
        if (us.delUser(ID)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return;
    }

    //修改用户界面
    public static void adminModifyUserShow() {
        System.out.println("==========================");
        System.out.println("修改用户界面");
        System.out.println("==========================");
        System.out.println("请输入要修改的用户的ID号码");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入要修改的用户的用户名");
        String username = sc.nextLine();
        System.out.println("请输入要修改的用户的密码");
        String password = sc.nextLine();
        System.out.println("请输入要修改的用户的权限（管理员/普通用户）");
        String admin = sc.nextLine();
        System.out.println("请输入部门号");
//        int deptId = sc.nextLine();?????????????????
        int deptId = Integer.parseInt(sc.nextLine());
        System.out.println("请输入职位号");
//        int jobId = sc.nextLine();???????????????????
        int jobId = Integer.parseInt(sc.nextLine());
        User user = new User(id, username, password, admin, deptId, jobId);
        UserService us = new UserServiceImpl();
        us.adminModifyUser(user);

    }

    //查询用户父界面
    public static void adminQueryUserShow() {
        while (true) {
            System.out.println("==========================");
            System.out.println("查询用户父界面");
            System.out.println("==========================");
            System.out.println("查询全部用户--------------1");
            System.out.println("根据id查询用户--------------2");
            System.out.println("根据姓名查询用户--------------3");
            System.out.println("返回上一级--------------4");
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    AdminView.queryAllUserShow();
                    break;
                case "2":
                    AdminView.queryByIdShow();
                    break;
                case "3":
                    AdminView.queryByNameShow();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("请重新输入");
                    break;
            }
        }


    }

    //子界面 查询所有用户
    public static void queryAllUserShow() {
        System.out.println("==========================");
        System.out.println("查询所有用户界面");
        System.out.println("==========================");
        UserService us = new UserServiceImpl();

        List<User> users = us.adminQueryAll();
        if (users.size() == 0) {
            System.out.println("查询结果为空");
        } else {
            Iterator<User> it = users.iterator();
            while (it.hasNext()) {
                User user = it.next();
//                System.out.println(user);
                System.out.println("id:" + user.getId() + "\t" + "用户名:" + user.getUsername() + "\t" + "密码:" + user.getPassword() + "\t"
                        + "权限:" + user.getAdmin() + "\t" + "部门号:" + user.getDeptId() + "\t" + "职位号" + user.getJobId());
                System.out.println("================================================");

            }
        }

    }

    //按照id查询用户
    public static void queryByIdShow() {
        System.out.println("==========================");
        System.out.println("按照id查询用户");
        System.out.println("==========================");
        System.out.println("请输入要查询的用户ID:");
        int id = Integer.parseInt(sc.nextLine());
        UserService us = new UserServiceImpl();
        User user = us.queryById(id);
        System.out.println(user);

    }

    //子界面 按名字查询（支持模糊查询）
    public static void queryByNameShow() {
        System.out.println("==========================");
        System.out.println("按名字查询用户");
        System.out.println("==========================");
        System.out.println("请输入要查询的用户名字（支持模糊查询）:");
        String name = sc.nextLine();
        UserService us = new UserServiceImpl();
        List<User> users = us.queryByName(name);
        if (users.size() == 0) {
            System.out.println("查询结果为空");
        } else {
            Iterator<User> it = users.iterator();
            while (it.hasNext()) {
                User user = it.next();
                System.out.println("id:" + user.getId() + "\t" + "用户名:" + user.getUsername() + "\t" + "密码:" + user.getPassword() + "\t"
                        + "权限:" + user.getAdmin() + "\t" + "部门号:" + user.getDeptId() + "\t" + "职位号" + user.getJobId());
                System.out.println("================================================");

            }
        }

    }
}
