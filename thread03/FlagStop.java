package thread03;

public class FlagStop {
    public static boolean isInterrupted = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   while (!isInterrupted){
                       System.out.println(Thread.currentThread().getName());
                       Thread.sleep(1000);
                   }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000);
        isInterrupted = true;
    }
}
