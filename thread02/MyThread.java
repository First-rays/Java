package thread02;

public class MyThread {
    public static void main(String[] args) {
        creatThreadTest ctt = new creatThreadTest("老王");
        ctt.start();
       //ctt.run();    // 一直在 run()方法中循环，没有退出
       while (true){

       }
    }
}

class creatThreadTest extends Thread{
    public creatThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        while (true){

        }
    }
}


