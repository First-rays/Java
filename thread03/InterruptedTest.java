package thread03;

public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        //ignoreInterrpt();
        interrptedTest();
    }
    private static void  ignoreInterrpt() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }


    private static void interrptedTest() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }

    private static void explain(){
        Thread.interrupted();       //返回 boolean 类型的值，并改为标志位初始化值
        //修改标志位
        //如果进程调用 sleep() wait() join()造成阻塞状态
        //

        Thread.currentThread().interrupt();
        //简单返回标志位
        Thread.currentThread().isInterrupted();
    }

}
