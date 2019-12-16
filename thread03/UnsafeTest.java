package thread03;

public class UnsafeTest {
    private static int number;

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    method();
                }
            }).start();
        }
        //Debug 的方式启动
        while (Thread.activeCount() > 1){
            Thread.yield();    //线程让步,当前线程从运行太转变为就绪状态
        }
        System.out.println(number);
    }
    private static synchronized void method(){
        for(int j = 0; j < 10000; j++){
            number++;
        }
    }

}



