package day12;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {

    //AACTGTGCACGACCTGA
    //5
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.next();
            int n = in.nextInt();
            int start = 0;
            int end = n;
            int count = 0;
            int maxCount = 0;
            for(int i=0; i < str.length(); i++){
                count = 0;
                for(int j = i; ((i+n <str.length())&& (j < i+n) ); j++){
                    if(str.charAt(j)=='C' ){
                        count++;
                    } else if(str.charAt(j) =='G'){
                        count++;
                    }
                }
                if(maxCount < count){
                    maxCount = count;
                    start = i;
                    end = i+n;
                }
            }
            for(int x = start; x < end; x++){
                System.out.print(str.charAt(x));
            }

        }
    }
}