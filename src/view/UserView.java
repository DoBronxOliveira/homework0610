package view;

import pojo.User;
import service.EmployeeServiceImpl;
import service.EmplyeeService;

import java.util.Scanner;

/**
 * @author Tan
 * @date 2023/6/12 22:34
 */
public class UserView {
    static Scanner sc = new Scanner(System.in);

    //用户主界面
    public static void show(User user) {
        System.out.println("欢迎登录到管理员主界面");
        System.out.println(user.getUsername() + "您好，您的权限是普通用户");
        while (true) {
            System.out.println("==========================");
            System.out.println("请选择功能");
            System.out.println("查看个人信息--------------1");
            System.out.println("修改个人信息--------------2");
            System.out.println("返回上一级----------------3");
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    employeeQueryItSelf(user);
                    break;
                case "2":
                    employeeModifyItSelf(user);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("请重新输入！");
                    break;
            }
        }
    }
    //查询个人信息界面
    public static void employeeQueryItSelf(User user) {

        System.out.println("您的个人信息如下：");
        System.out.println("id:" + user.getId() + "\t" + "用户名:" + user.getUsername() + "\t" + "密码:" + user.getPassword() + "\t"
                + "权限:" + user.getAdmin() + "\t" + "部门号:" + user.getDeptId() + "\t" + "职位号" + user.getJobId());
        System.out.println("================================================");
        return;

    }
    //修改用户界面
    public static void employeeModifyItSelf(User user) {
        System.out.println("==========================");
        System.out.println("修改用户界面");
        System.out.println("==========================");
        System.out.println("请输入要修改的用户的用户名");
        String username = sc.nextLine();
        System.out.println("请输入要修改的用户的密码");
        String password = sc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        EmplyeeService es=new EmployeeServiceImpl();
        es.userModify(user);

    }


}

