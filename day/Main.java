package day;

import java.util.ArrayList;
import java.util.Scanner;

//import static org.graalvm.compiler.debug.TTY.printf;

//public class Main {
//    //5
//    //4 3 4 2 3
//    //91 88 72 69 56
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int num = in.nextInt();
//            ArrayList<Integer> arrayList1 = new ArrayList<>();
//            ArrayList<Double> arrayList2 = new ArrayList<>();
//            int count = 0;
//            for(int i = 0; i < num; i++){
//                int tem = in.nextInt();
//                arrayList1.add(i,tem);
//                count += tem;
//            }
//            for(int i = 0; i < num; i++){
//                int tem = in.nextInt();
//                if(tem >=90 && tem <=100){
//                    arrayList2.add(i,4.00);
//                } else if(tem >=85 && tem <= 89){
//                    arrayList2.add(i,3.7);
//                } else if(tem >= 82 && tem <= 84){
//                    arrayList2.add(i,3.3);
//                } else if(tem >= 78 && tem <= 81){
//                    arrayList2.add(i,3.1);
//                } else if(tem >= 75 && tem <= 77){
//                    arrayList2.add(i, 2.7);
//                } else if(tem >= 72 && tem <= 74){
//                    arrayList2.add(i, 2.3);
//                } else if(tem >= 68 && tem <= 71){
//                    arrayList2.add(i, 2.0);
//                } else if(tem >= 64 && tem <= 67){
//                    arrayList2.add(i, 1.5);
//                } else if(tem >= 60 && tem <= 63){
//                    arrayList2.add(i, 1.0);
//                } else{
//                    arrayList2.add(i,0.0);
//                }
//            }
//            ArrayList<Double> arrayList3 = new ArrayList<>();
//            for(int j = 0; j < num; j++){
//                arrayList3.add(arrayList1.get(j)*arrayList2.get(j));
//            }
//            double result = 0;
//            for(int i = 0; i < num; i++){
//                result += arrayList3.get(i);
//            }
//            System.out.printf("%.2f",result/count);
//
//
//        }
//    }
//}

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            double tem = in.nextDouble();


        }
    }
}