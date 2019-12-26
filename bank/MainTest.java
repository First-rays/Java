package bank;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        BankTest bankTest = new BankTest();
        do{
            menu();
            System.out.println("请输入选择：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice == 1){
                bankTest.init();
            } else if(choice == 2){
                bankTest.safeTest();
                bankTest.show();
            } else if(choice == 3){
                bankTest.setFalse();
                bankTest.banker();
            } else if(choice == 4){
                bankTest.showAuail();
            } else if(choice == 5){
                bankTest.quit();
            } else{
                System.out.println("输入有误，重新输入！");
            }
        }while (true);
    }

    private static void menu(){
        System.out.println("******************************");
        System.out.println("***** 1. 初始化信息     ******");
        System.out.println("***** 2. 安全性检测     ******");
        System.out.println("***** 3. 银行家算法     ******");
        System.out.println("***** 4. 显示可用资源数 ******");
        System.out.println("***** 5. 退出系统       ******");
        System.out.println("******************************");


    }
}
