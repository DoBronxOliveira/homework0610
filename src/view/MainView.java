package view;

import java.util.Scanner;


/**
 * @author Tan
 * @date 2023/6/12 11:35
 */


public class MainView {
    static Scanner sc = new Scanner(System.in);

    public static void run() {

        while (true) {
            System.out.println("==========================");
            System.out.println("欢迎使用员工管理系统");
            System.out.println("==========================");
            System.out.println("用户登录---------1");
            System.out.println("用户注册---------2");
            System.out.println("退出程序---------3");
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    LoginView.show();
                    break;
                case "2":
                    RegisterView.show();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("请重新输入");
                    break;
            }
        }
    }
}



