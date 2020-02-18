package Tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TcpServer {

    private static final int Port = 9999;
    /**
     * 原生线程池创建方式
     * 参数1，核心线程数
     * 参数2，最大线程数
     * 参数3+4，一定数量的时间+时间单位，在时间内，临时工的线程没有任务处理，
     * 就把临时工解雇掉（关闭线程）
     * 参数5，无边界的工作队列
     * 参数6，代表任务数量超出最大值，线程池该怎么做（4种策略）
     */
    private static final ThreadPoolExecutor POOL = new ThreadPoolExecutor(
            0,Integer.MAX_VALUE,30,TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy()
    );

    //单个线程池
    private static final ExecutorService EVE = Executors.newSingleThreadExecutor();
    //可缓存的线程池:正式编制为0，所有线程都是临时工
    //private static final ExecutorService EVE = Executors.newCachedThreadPool();
    //定时任务的线程池
    //private static final ExecutorService EVE =Executors.newScheduledThreadPool();
    //固定大小的线程池:只有固定数量编制的正式工
    //private static final ExecutorService EVE =Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws IOException {

        //启动服务器
        ServerSocket serverSocket = new ServerSocket(Port);
        //阻塞，等待新的客户端连接

        while (true){
            Socket socket = serverSocket.accept();
            //处理这个客户端连接的业务，这个业务可能会发生阻塞
            //先不考虑阻塞的实现

            EVE.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));

                        OutputStream os = socket.getOutputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));

                        String line;
                        //阻塞客户端传过来的新的一行数据
                        while((line = br.readLine()) != null){
                            System.out.println("服务端接收数据："+line);
                            bw.write("我已经接收到了"+line+"消息\n");
                            //需要刷新一下缓冲区，这个时候才会将数据发送到对端

                            bw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }


    }
}
