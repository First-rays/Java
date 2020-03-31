// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
package day17;
import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int num = in.nextInt();
//
//            System.out.println(sub(num)+" "+sub(num*num));
//        }
//    }
//    private static int sub(int num){
//        int sum = 0;
//        while(num != 0){
//            sum += num % 10;
//            num /= 10;
//        }
//        return sum;
//    }
//}

public class Main {
    public static  void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int num = in.nextInt();
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < num; i++) {
                String s = in.next();
                hashMap.put(s, 0);
            }
            int peopleNum = in.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < peopleNum; i++) {
                String s = in.next();
                list.add(s);
            }
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (hashMap.containsKey(list.get(i))) {
                    hashMap.put(list.get(i),
                            hashMap.getOrDefault(list.get(i), 0) + 1);
                    count++;
                }
            }
//            for(int i = 0; i < hashMap.size(); i++){
//                System.out.println(hashMap.keySet() +":"+hashMap.get(i));
//            }
            for(String key:hashMap.keySet())
            {
                System.out.println(key+" : "+hashMap.get(key));
            }
            System.out.println("Invalid : "+(list.size()-count));


        }
    }
}
