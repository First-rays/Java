package day10;

import java.util.*;


//
//// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//public class Main02 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        List<Integer> list = new LinkedList<>();
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//            list.add(n);
//        }
//        Collections.sort(list);
//        if(list.contains(0)){
//            for(int i = 0; i < list.size(); i++){
//                if(list.get(i)>0){
//                    list.add(0,list.get(i));
//                    list.add(i,0);
//                }
//            }
//        }
//        for(int i = 0; i < list.size(); i++){
//            System.out.print(list.get(i)+" ");
//        }
//    }
//}
//
//public class Main02 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(sc.nextInt());
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) != 0) {
//                sb.append(i);
//                list.set(i, list.get(i) - 1);
//                break;
//            }
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) != 0) {
//                for (int j = 0; j < list.get(i); j++) {
//                    sb.append(i);
//                }
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
//
//}

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        System.out.print(GetSequeOddNum(m));
    }
    public static String GetSequeOddNum(int m){
        if(m==1){
            return new String("1");
        }
        List<Integer> list = new LinkedList<>();
        int count =0;
        for(int i =1; i<=m/2;i++){
            if(m*m%2==0){
                int j = 2*i-1;
                list.add(m*m-j);
                list.add(m*m+j);
            } else {
                int j = 2 * i;
                list.add(m * m - j);
                list.add(m * m + j);
            }
            count++;

        }
        if(count != m){
            list.add(m*m);
        }
        Collections.sort(list);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < list.size();i++){
            stringBuffer.append(list.get(i));
            if(i != list.size()-1){
                stringBuffer.append("+");
            }

        }

        return stringBuffer.toString();
    }
}