package day05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

//    public static void main(String[] args) {
//        StringBuilder a = new StringBuilder("A");
//        StringBuilder b = new StringBuilder("B");
//        FUN(a,b);
//        System.out.println(a+"."+b);
//    }
//    public static void FUN(StringBuilder x,StringBuilder y){
//        x.append(y);
//        y = x;
//    }
////两个栈实现队列
//    public class Solution {
//        Stack<Integer> stack1 = new Stack<Integer>();
//        Stack<Integer> stack2 = new Stack<Integer>();
//
//        public void push(int node) {
//            stack1.push(node);
//        }
//
//        public int pop() {
//           int tem = 0;
//            while(!stack1.isEmpty()){
//                stack2.push(stack1.pop());
//
//            }
//            tem = stack2.pop();
//            while (!stack2.isEmpty()){
//                stack1.push(stack2.pop());
//            }
//            return tem;
//        }
//    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 0; //计数
    while(sc.hasNext()){
        int n = sc.nextInt();
        int []array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        for(int i =0; i < n; i++){
            int max = array[i];
            for(int j =i + 1; j < n; j++){
                max +=array[j];
                if(max == 40){
                    count++;
                }else if(max>40){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

}
