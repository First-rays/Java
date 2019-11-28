
import process.*;
import realize.*;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        while (true){
            menu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1){
                Init.initMessage();
            } else {
                System.out.println("请先初始化信息！");
            }
            menu();
            if(choice == 2){
                ChooseAlgo.chooseOneAlgo();
            }
            if(choice == 3){
                System.out.println("退出成功！");
                System.exit(-1);
            }
        }
    }

    public static void menu(){
        System.out.println("*************************");
        System.out.println("***** 1.录入信息     ****");
        System.out.println("***** 2.选择调度算法 *****");
        System.out.println("***** 3.退出         *****");
        System.out.println("*************************");
    }
}
