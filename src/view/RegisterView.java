package view;

import service.UserService;
import service.UserServiceImpl;
import pojo.User;
import util.StringUtil;

import java.util.Scanner;
/**
 * @author Tan
 * @date 2023/6/12 12:50
 */


public class RegisterView {

    static Scanner sc = new Scanner(System.in);

    public static void show() {
        System.out.println("用户注册界面");
        System.out.println("==========================");
        System.out.println("请输入您的用户名");
        String username = sc.nextLine();
        System.out.println("请输入您的密码");
        String pwd = sc.nextLine();
        String randomStr = StringUtil.getRandomStr(4);
        System.out.println("请输入验证码：" + randomStr);
        String inputRandomStr = sc.nextLine();
        if (inputRandomStr.equals(randomStr)) {
            User user = new User(username, pwd, "普通用户");
            UserService us = new UserServiceImpl();
            if (us.register(user)) {
                System.out.println("用户注册成功，请重新登录");
            } else {
                System.out.println("用户名已存在或为空，用户注册失败");
            }
            return;
        }else {
            System.out.println("验证码错误");
        }

    }
}

