package day11;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
//统计同成绩学生人数
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        while (sc.hasNext()){
            int n = sc.nextInt();
            for(int i = 0; i<n; i++ ){
                int x = sc.nextInt();
                hashMap.put(x,
                        hashMap.getOrDefault(x,0)+1);
            }
            int m = sc.nextInt();
            if(hashMap.containsKey(m)){
                System.out.println(hashMap.get(m));
            }
        }

    }


}
