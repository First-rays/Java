package package1212;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpDemo {

    public static void main(String[] args) throws IOException {
        //创建 socket 对象
        Socket s = new Socket(InetAddress.getByName("DESKTOP-I0QO0K0"),10000);
        //
        OutputStream os  = s.getOutputStream();
        //发送数据
        String str = "hello world";
        os.write(str.getBytes());
        //释放资源
        //os.close();
        s.close();
    }
}
