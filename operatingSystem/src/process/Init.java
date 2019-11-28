package process;

import java.util.Scanner;

public class Init {
    public static void initMessage(){
        for(int i = 1; i <= 5; i++){
            System.out.println("请输入进程" + i + "的相关信息：");
            System.out.print("进程名   进入时间    服务时间    优先级    时间片");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            Process.processes[i-1].setProcessName(name);


        }
    }
}
