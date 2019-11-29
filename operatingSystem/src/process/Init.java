package process;


import java.util.Scanner;

public class Init {
    public  static int number = 10;
    public  static Process []processes = new Process[number];

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void initMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入进程个数：");
        int number1 = scanner.nextInt();
        setNumber(number1);
        for(int i = 0; i < number; i++){
            int x = i + 1;
            System.out.println("请输入进程" + x + "的相关信息：");
            System.out.println("进程名   进入时间    服务时间    优先级    时间片");
            processes[i] = new Process();
            String name = scanner.next();
            processes[i].setProcessName(name);
            int inTime = scanner.nextInt();
            processes[i].setInTime(inTime);
            int serviceTime = scanner.nextInt();
            processes[i].setServiceTime(serviceTime);
            int grade = scanner.nextInt();
            processes[i].setGrade(grade);
            int time = scanner.nextInt();
            processes[i].setTime(time);
        }
    }
    public void sort(){
        for(int i = 0; i < number - 1;i++){
            for(int j = 0; j < number - i -1; j++){
                if(processes[j].getInTime() > processes[j+1].getInTime()){
                    Process p = processes[j];
                    processes[j] = processes[j+1];
                    processes[j+1] = p;
                }
            }
        }
    }
    public void sort2(){
        for(int i = 0; i < number - 1;i++){
            for(int j = 0; j < number - i -1; j++){
                if(processes[j].getServiceTime() > processes[j+1].getServiceTime()){
                    Process p = processes[j];
                    processes[j] = processes[j+1];
                    processes[j+1] = p;
                }
            }
        }
    }



}
