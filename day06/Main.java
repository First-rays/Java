package day06;
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.*;

//public class Main {

    //n个数里出现次数大于等于n/2的数
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List list = new ArrayList();
//        int n = 0;
//        while(sc.hasNext()){
//           list.add(sc.nextInt());
//
//        }
//        Collections.sort(list);
//        System.out.println(list.get(list.size()/2));
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList();
//        while(sc.hasNext()){
//            list.add(sc.nextInt());
//        }
//        Integer A;
//        Integer B;
//        Integer C;
//        A = (list.get(0) + list.get(2)) / 2;
//        B = (list.get(1) + list.get(3)) / 2;
//        C = list.get(1) - B;
//        if(((A-B) == list.get(0)) &&((B-C) == list.get(1))
//                &&((A+B) == list.get(2))
//                && ((B+C) == list.get(3))){
//            System.out.print(A+" "+B+" "+C);
//        } else{
//            System.out.println("No");
//        }
//    }
//}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []arr = new int [4];
        for(int i = 0; i < 4; i++){
            arr[i] = sc.nextInt();
        }
        int A;
        int B;
        int C;

        A = (arr[0] + arr[2]) / 2;
        B = (arr[1] + arr[3]) / 2;
        C= B - arr[1];
        if(((A-B) == arr[0]) &&((B-C) == arr[1])
                &&((A+B) == arr[2])
                && ((B+C) == arr[3])){
            System.out.print(A+" "+B+" "+C);
        } else{
            System.out.println("No");
        }

    }
}