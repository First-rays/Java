package thread02;

public class ThreadAdvantage {

    private static final long num = 1000000000L;
    public static void serial(){
        for(int i = 0; i < num; i++){
            i++;
        }
    }

    public static void parallel(){
        for(int i = 0; i < 2; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    serial();
                }
            }).start();
        }
    }


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        serial();
        serial();
        long t2 = System.currentTimeMillis();
        System.out.println("串行"+(t2-t1)+"毫秒");


        long t3 = System.currentTimeMillis();
        parallel();
        while (Thread.activeCount()> 1)
            Thread.yield();
        long t4 = System.currentTimeMillis();
        System.out.println("并行"+(t4-t3)+"毫秒");
    }
}
