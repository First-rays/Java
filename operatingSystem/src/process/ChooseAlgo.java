package process;

import realize.Fcfs;
import realize.Psa;
import realize.Rr;
import realize.Sjf;

import java.util.Scanner;

public class ChooseAlgo {
    public void chooseOneAlgo(){
        IprocessContral[] chooseProcess = new IprocessContral[]{
                new Fcfs(),
                new Sjf(),
                new Psa(),
                new Rr()
        };
        menu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1 || choice == 2 || choice == 3 || choice == 4){
            chooseProcess[choice - 1].processContral();
        }
    }
    public static void menu(){
        System.out.println("***************************");
        System.out.println("**** 1.先来先服务算法  ****");
        System.out.println("**** 2.短进程优先算法  ****");
        System.out.println("**** 3.高优先级算法    ****");
        System.out.println("**** 4.时间片轮转      ****");
        System.out.println("****************************");
    }
}
