package day15;

import java.util.HashMap;
import java.util.Scanner;

//public class Main {
//    //  斐波拉契数列
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int mouthCount = in.nextInt();
//
//            int count = getTotalCount(mouthCount);
//            System.out.println(count);
//        }
//
//
//    }
//    public static int getTotalCount(int mouthCount){
//        int total = 0;
//        int m1 = 1;
//        int m2 = 1;
//        for(int i = 3; i <= mouthCount; i++){
//            total = m1 + m2;
//            m1 = m2;
//            m2 = total;
//        }
//        return total;
//    }
//}
public class Main {

    //HELLO WORLD
    //SNHJ
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character,Character> hashMap = new HashMap<>();
        for(char a = 'F'; a <= 'z'; a++){
            hashMap.put(a,(char)(a-5));
        }
        hashMap.put('A','V');
        hashMap.put('B','W');
        hashMap.put('C','X');
        hashMap.put('D','Y');
        hashMap.put('E','Z');
        hashMap.put(' ',' ');
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            for(int i =0; i < str.length(); i++){
                System.out.print(hashMap.get(str.charAt(i)));
            }
            System.out.println();
        }
    }
}