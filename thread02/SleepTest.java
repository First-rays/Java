package thread02;

import java.util.Date;

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        // 日期类 ：1970-01-01 00：00：00
        Date date = new Date();
        long current = date.getTime();
        long c = System.currentTimeMillis();
        Thread.sleep(5000); // 作用在 main 线程

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++){
                        System.out.println(i);
                            Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 判断你进程是否结束，看非守护进程是否结束
        //非守护进程，自己 new 的进程
        //主进程结束，子进程不一定结束
        //所有非守护进程结束，进程一定结束

    }
}
