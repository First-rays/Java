package day13;
import java.util.*;
//import java.util.HashSet;
//
//public class Main {
//    public static boolean[] chkSubStr(String[] p, int n, String s) {
//        // write code here
//        boolean []booleans = new boolean[n];
//        for(int j = 0; j < n; j++){
//            if(s.indexOf(p[j])>=0){
//                booleans[j] = true;
//            } else{
//                booleans[j] = false;
//            }
//        }
//        return booleans;
//    }
//
//
//    public static void main(String[]args){
//        String [] p = {"a","b","d"};
//        String s = "abc";
//        boolean booleans[] = chkSubStr(p,3,s);
//        for(boolean b : booleans){
//            System.out.println(b);
//        }
//    }
//
//}
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

import java.util.Scanner;
public class Main {

    //3
    //0
    //fang 90
    //yang 50
    //ning 70
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int flag = in.nextInt();
            String strings[] = new String[n];
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                String s = in.next();
                Integer grades = in.nextInt();
                strings[i] = s;
                arr[i] = grades;
            }
//            if(flag == 1){
//                sqrt1(arr,strings);
//            } else{
//                sqrt0(arr,strings);
//            }
            sqrt(arr,strings,flag);
            for(int i = 0; i < n; i++){
                System.out.println(strings[i]+" "+arr[i]);
            }
        }
    }
    private static void sqrt(int []arr, String[]strings ,int flag){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j]>arr[j+1] && flag == 1){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;

                    String s = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = s;
                } else if(arr[j]<arr[j+1] && flag == 0){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;

                    String s = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = s;
                }
            }
        }
    }

    private static void sqrt1(int []arr, String[]strings){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;

                    String s = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = s;
                }
            }
        }
    }
    private static void sqrt0(int []arr, String[]strings){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j]<arr[j+1]){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;

                    String s = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = s;
                }
            }
        }
    }
}