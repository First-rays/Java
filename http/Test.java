package http;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {


        //类加载器
        //classLoader以编译输出文件夹根目录作为相对的标准位置
        InputStream is = Test.class.getClassLoader().getResourceAsStream("login.html");
        System.out.println(is);
    }
}
