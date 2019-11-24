package map_set;

import java.util.*;

public class BrokenKeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            Map<Character,Integer> hashMap = new HashMap<>();
            Integer count = 1;
            for(int i = 0; i < s1.length(); i++){
                hashMap.put(s1.charAt(i),count);
            }
            for(int j = 0; j < s2.length(); j++){
                count = hashMap.get(s2.charAt(j));
                hashMap.put(s2.charAt(j), count + 1);
            }
            for(Character x : hashMap.keySet()){
                if(hashMap.get(x) == 1){
                    System.out.print(x);
                }
            }
            System.out.println();
        }
    }
}
