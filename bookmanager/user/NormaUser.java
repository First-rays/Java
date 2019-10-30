package bookmanager.user;

import bookmanager.operation.*;

import java.util.Scanner;

public class NormaUser extends User{
    public NormaUser(String name) {
        super(name);
        operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("欢迎登录图书管理系统");
        System.out.println("hello" + name);
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
