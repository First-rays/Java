package bookmanager;

import bookmanager.book.BookList;
import bookmanager.user.User;
import bookmanager.user.NormaUser;
import bookmanager.user.Admin;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();

        while (true){

            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }


    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入你的角色1）普通用户。2）管理员");
        int role = scanner.nextInt();
        if(role == 1){
            return new NormaUser(name);
        } else{
            return new Admin(name);
        }
    }
}
