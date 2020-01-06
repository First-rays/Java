package package0106;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoTest {

    public static void main(String[] args) throws IOException {
       /* File file = new File("H:/abc");

        file.createNewFile();*/
      /*  File file = new File("H:/abc/a/b");
        file.mkdirs();
*/
//        File file = new File("H:/abc/a");
//        File[] children = file.listFiles();
//
//        for(File child : children){
//            System.out.println(child);
//        }
            FileInputStream fin=new FileInputStream("H:\\bit\\a.txt");
            FileOutputStream fout=new FileOutputStream("H:\\bit\\Copy.txt");
            int len=0;
            byte[] buff=new byte[1024];
            while((len=fin.read(buff))!=-1) {
                fout.write(buff, 0, len);
            }
            fin.close();
            fout.close();
        }



}
