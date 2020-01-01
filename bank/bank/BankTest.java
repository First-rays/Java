package bank;

import java.util.*;

public class BankTest {
        public Process[] process;
        Source sou = new Source();  //初始化资源的个数
        public Queue<Integer> queue = new LinkedList<>();
        public void init() {
            Process pro = new Process();
            System.out.println("输入进程的个数："); //初始化进程的个数
            Scanner sc = new Scanner(System.in);
            int pro_num = sc.nextInt();
            pro.proNumber = pro_num;
            //Source sou = new Source();  //初始化资源的个数
            System.out.println("初始化各资源的个数：");
            int sou_num = sc.nextInt();
            sou.souNumber = sou_num;
            process = new Process[pro_num];
            //初始化 Max 矩阵
            for(int i = 0; i < pro_num; i++){
                process[i] = new Process();
                System.out.println("初始化第"+(i+1)+"个进程的最大需求数：");
                for(int j = 0; j < sou_num; j++){
                    Integer number = sc.nextInt();
                    process[i].Max.add(j,number);
                }
            }

            //初始化最大资源总数 (AV)
            //System.out.println(Source.avail.length);
            System.out.println("初始化"+pro_num+"个进程的最大资源总数：");
            for(int i = 0; i < sou_num; i++){
                Integer number = sc.nextInt();
                sou.MaxSource.add(i, number);
            }


            //初始化各进程已分配资源总数
            //System.out.println(process.length);
            for(int i = 0; i < pro_num; i++){
                System.out.println("初始化第"+(i+1)+"个进程的已分配的资源数：");
                for(int j = 0; j < sou_num; j++){
                    Integer number = sc.nextInt();
                    process[i].AL.add(j,number);
//                    int R = sou.AVAIL.get(j);
//                    sou.AVAIL.add(i,R-number);
                }
            }
            //初始化各进程还需资源总数 (need)
            for(int i = 0; i < pro_num; i++){
                for(int j = 0; j < sou_num; j++){
                    Integer number = process[i].Max.get(j) - process[i].AL.get(j);
                    process[i].need.add(j,number);
                }
            }
            //初始化各进程完成情况 (finish)
            System.out.println("初始化"+ pro_num+"个的finish数组情况:");
            for(int i = 0; i < pro_num; i++){
                boolean number = sc.nextBoolean();
                process[i].Finish.add(0,number);
            }

            //计算 AVAIL 的值
            for(int j = 0; j < sou_num; j++){
                Integer number = 0;
                int i = 0;
                for(; i < pro_num; i++){
                    number += process[i].AL.get(j);
                }
                sou.AVAIL.add(j, sou.MaxSource.get(j) - number);
            }
        }
        //输出函数

    public void show(){
        int []arr = new int[queue.size()];
        int x = 0;
        System.out.println();
        System.out.println("    work        need        AL      work+AL     Finish");
        while(!queue.isEmpty()){
            int i = queue.poll();
            arr[x] = i;
            x++;
            System.out.print(i+":"+"  ");
            for(int j = 0; j < Source.souNumber; j++){
                System.out.print(process[i].Work.get(j)+" ");
            }
            System.out.print("      ");
            for(int j = 0; j < Source.souNumber; j++){
                System.out.print(process[i].need.get(j)+" ");
            }
            System.out.print("     ");
            for(int j = 0; j < Source.souNumber; j++){
                System.out.print(process[i].AL.get(j)+" ");
            }
            System.out.print("     ");
            for(int j = 0; j < Source.souNumber; j++){
                System.out.print(process[i].Work_Al.get(j)+" ");
            }
            System.out.print("      ");
            System.out.println(process[i].Finish.get(0));
        }
        System.out.println("安全序列为：");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    //对于安全性检测的处理
        public void safeTest(){
            int flag = 0;
            int x = 0;
            for (int i = 0; i < Process.proNumber; i++) {
                flag = 0;
                for (int j = 0; j < Source.souNumber; j++) {
                    //当所需资源大于可用资源时，跳出此次循环
                    if (process[i].need.get(j) > sou.AVAIL.get(j)) {
                        flag = 1;
                        break;
                    } else{
                        continue;
                    }
                } //end for(j)
                // 此处有两种情况 1. 当所需资源大于可用资源时 flag==1
                if(flag == 0 && process[i].Finish.get(0) == false){
                    // 2.正常结束循环，满足所需资源大于可用资源
                    //将 available 数组值 写到work 中
                    copy(i);
                    x = i;
                    queue.offer(i);
                    calaTem(x);
                    break;
                }
            }//end for(i)
            if(flag == 1){
                System.out.println("不安全，可用资源数不满足所有的进程所需！");
                return;
            }
            while(true){
                int tem = queue.size();
                for(int i = 0; i < Process.proNumber; i++){
                    flag = 0;
                    for(int j = 0; j < Source.souNumber; j++){
                        if((queue.contains(i)) || process[x].Work_Al.get(j) < process[i].need.get(j)){
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        continue;
                    }
                    //第 x 进程的 work+al 的值 赋值给 第 i 进程的work
                    copy1(i, x); //更新work
                    queue.offer(i);
                    x = i;
                    calaTem(x); //更新work + all
                    if(queue.size() == process.length){
                        System.out.println(queue.size());
                        return;
                    }
                }
               if(tem == queue.size()){
                   System.out.println("无安全序列！因为这些进程无法被满足");
                    return;
                }
            }

        }

        //计算 work + AL 的值
        private void calaTem(int x){
            for(int j = 0; j < Source.souNumber; j++){
                process[x].Work_Al.add(j,process[x].Work.get(j) + process[x].AL.get(j));
            }
            process[x].Finish.add(0,true);
        }



    public void banker(){
        System.out.println("输入进程号与"+Source.souNumber+"种请求资源：");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        for(int i = 0; i < Source.souNumber; i++){
            int number = sc.nextInt();
            process[index].Request.add(i,number);
        }
        //判断request <= need
        for(int i = 0; i < Source.souNumber; i++){
            if(process[index].Request.get(i)>process[index].need.get(i)){
                System.out.println("request > need");
                return;
            }
        }
        //判断request <= avail
        for(int i = 0; i < Source.souNumber; i++){
            if(process[index].Request.get(i)>sou.AVAIL.get(i)){
                System.out.println("request > available");
                return;
            }
        }

        Process[] p = new Process[1];
        p[0] = new Process();
        for(int i = 0; i < Source.souNumber; i++){
            p[0].need.add(i, process[index].need.get(i));
            p[0].AL.add(i,process[index].AL.get(i));
            p[0].Work_Al.add(i,sou.AVAIL.get(i));
        }

        for(int i = 0; i < Source.souNumber; i++){
            sou.AVAIL.set(i, sou.AVAIL.get(i) - process[index].Request.get(i));
            process[index].need.set(i,process[index].need.get(i)-process[index].Request.get(i));
            process[index].AL.set(i,process[index].AL.get(i)+process[index].Request.get(i));
        }
        int f = 0;
        for(int i= 0; i < Source.souNumber; i++){
            if(process[index].need.get(i) != 0){
                f = 1;
                break;
            } else{
                f = 0;
            }
        }
        // request == need
        if(f == 0){
            for(int i = 0; i < Source.souNumber; i++){
                sou.AVAIL.set(i, process[index].AL.get(i) + sou.AVAIL.get(i));
                process[index].AL.set(i,0);
            }
        }
        print();
        //showAuail();
        //setFalse();
        safeTest();
        if(queue.size() == process.length){
            show();
            return;
        } else{

            for(int i = 0; i < Source.souNumber; i++){
                process[index].need.add(i,p[0].need.get(i));
                process[index].AL.add(i,p[0].AL.get(i));
                sou.AVAIL.add(i,p[0].Work_Al.get(i));
            }
            System.out.println("无安全序列！");
        }
    }
        public void showAuail(){
            //show();
            for(int i = 0; i < Source.souNumber; i++){
                System.out.print(sou.AVAIL.get(i)+" ");
            }
            System.out.println();
        }

        private void print() {
            System.out.println("need        AL ");
            for (int i = 0; i < Process.proNumber; i++) {
                for (int j = 0; j < Source.souNumber; j++) {
                    System.out.print(process[i].need.get(j) + " ");
                }
                System.out.print("     ");
                for (int j = 0; j < Source.souNumber; j++) {
                    System.out.print(process[i].AL.get(j) + " ");
                }
                System.out.println();
            }
        }
        //拷贝函数
        private void copy(int i){
            for(int j = 0; j < Source.souNumber; j++){
                process[i].Work.add(j,sou.AVAIL.get(j));
            }
            process[i].Finish.set(0,true);
        }
        private void copy1(int i, int x){
            for(int j = 0; j < Source.souNumber; j++){
                process[i].Work.add(j, process[x].Work_Al.get(j));
            }
            process[i].Finish.set(0,true);
        }

    public void setFalse(){
        for(int j = 0; j < Process.proNumber; j++){
            process[j].Finish.set(0,false);
        }

    }
        //退出函数判断
        public void quit(){
            System.out.println("退出成功！");
            System.exit(-1);
        }

    }
