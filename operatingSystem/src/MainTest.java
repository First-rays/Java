
import process.*;
import realize.*;

import java.lang.Process;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        while (true){
            menu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1){
                Init init = new Init();
                init.initMessage();
            }else if(choice == 2){
                ChooseAlgo chooseAlgo = new ChooseAlgo();
                chooseAlgo.chooseOneAlgo();
                show();
            } else if(choice == 3){
                System.out.println("退出成功！");
                System.exit(-1);
            } else{
                System.out.println("无此选项！");
            }
        }
    }

    private static void show(){
        Init init = new Init();
        for(int i = 0; i < init.getNumber(); i++){
            System.out.println(init.processes[i]);
        }
    }
    public static void menu(){
        System.out.println("*************************");
        System.out.println("***** 1.录入信息     ****");
        System.out.println("***** 2.选择调度算法 ****");
        System.out.println("***** 3.退出         ****");
        System.out.println("*************************");
    }
}
