package thread;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        Thread t1 = new Thread(td);
        t1.setName("窗口1");
        Thread t2 = new Thread(td);
        t2.setName("窗口2");
        Thread t3 = new Thread(td);
        t3.setName("窗口3");


        t1.start();
        t2.start();
        t3.start();
    }
}
