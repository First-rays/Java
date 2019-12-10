package thread;

public class ThreadDemo implements Runnable{
    int tickets = 100;

    @Override
    public void run() {
       method();

    }


    private synchronized void method(){
        while(true){
            if(tickets > 0){
                System.out.println(Thread.currentThread().getName()+":"+tickets--);

            }

        }
    }
}
