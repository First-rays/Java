package Tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {

    //本机默认域名就是localhost, 默认ip就是 127.0.0.1
    private static final String HOST = "localhost";
    //private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,PORT);

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));

        OutputStream os = socket.getOutputStream();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));
        PrintWriter pw = new PrintWriter(os,true);


        //String line;
        Scanner scanner = new Scanner(System.in);
        //阻塞客户端传过来的新的一行数据
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();//已经除去了换行符

            //发送数据报到服务端
            pw.println(line);
            //接受服务端的响应信息
            String response = br.readLine();

            System.out.println("接收到服务器端响应：" + response);



         }
    }
}
