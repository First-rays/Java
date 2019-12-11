package package1211;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Udpservlet {
    public static void main(String[] args) throws IOException {
        //创建接收 socket 对象
        DatagramSocket ds = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);


        //接收数据
        System.out.println(1);
        ds.receive(dp);
        System.out.println(2);
        //解析数据
        InetAddress address = dp.getAddress();
        byte[] data = dp.getData();
        int length = dp.getLength();
        System.out.println(address.getHostAddress());
        System.out.println(new String(bytes,0,length));
        //释放资源
        ds.close();
    }
}
