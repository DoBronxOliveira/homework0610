package view;

/**
 * @author Tan
 * @date 2023/6/12 12:50
 */

import service.UserService;
import service.UserServiceImpl;
import util.StringUtil;

import java.util.Scanner;


public class LoginView {

    static Scanner sc = new Scanner(System.in);

    // 登录界面
    public static void show() {

        System.out.println("==========================");
        System.out.println("用户登录界面");
        System.out.println("==========================");
        System.out.println("请输入您的用户名");
        String username = sc.nextLine();
        System.out.println("请输入您的密码");
        String password = sc.nextLine();
        String randomStr = StringUtil.getRandomStr(4);
        System.out.println("请输入验证码：" + randomStr);
        String inputRandomStr = sc.nextLine();
        if (inputRandomStr.equals(randomStr)) {
            UserService us = new UserServiceImpl();
            us.login(username, password);
//            return;
        } else {
            System.out.println("验证码错误");
//            return;
        }
    }


}

