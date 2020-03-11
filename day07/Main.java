package day07;

// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.*;
//n个数里最小的k个
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList();
//        while(sc.hasNext()){
//            list.add(sc.nextInt());
//        }
//        int n = list.get(list.size()-1);
//        list.remove(list.size()-1);
//        Collections.sort(list);
//        for(int i = 0; i < n; i++){
//            System.out.print(list.get(i)+" ");
//        }
//    }
//}

//删数
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue2 = new LinkedList<>();
        int count = 0;
        int index = 0;
        while(sc.hasNext()){


        }
        while(!queue2.isEmpty()){
            count = 0;
            while(count < 2){

                ((LinkedList<Integer>) queue2).push(((LinkedList<Integer>) queue2).pop());

                ((LinkedList<Integer>) queue2).pop();
            }
            if(queue2.size() == 1){
                System.out.println( ((LinkedList<Integer>) queue2).pop());
                return;
            }
        }

    }
}