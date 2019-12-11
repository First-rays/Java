package package1211;

import java.io.IOException;
import java.net.*;

public class UdpDemo {

    public static void main(String[] args) throws IOException {

        //创建发送端 socket 对象
        DatagramSocket ds = new DatagramSocket();
         String str = "hello world";
        byte[] bys = str.getBytes();
        int len = bys.length;
        int port = 8888;
        InetAddress address = InetAddress.getByName("DESKTOP-I0QO0K0");
        DatagramPacket dp = new DatagramPacket(bys, len, address, port);
        //发送资源
        ds.send(dp);
        //释放资源
        ds.close();
    }
}
