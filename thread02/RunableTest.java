package thread02;

public class RunableTest {
    public static void main(String[] args) {
        MyRunaable myRunaable = new MyRunaable();
        Thread t = new Thread(myRunaable);
        t.setName("老王");
        t.start();

        System.out.println(Thread.currentThread().getName());
    }

}
class MyRunaable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}