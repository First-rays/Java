package package1209;

import java.util.HashMap;

public class MainTest02 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            } else{
                hashMap.put(s.charAt(i),1);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(hashMap.get(s.charAt(i)) >= 2){
                continue;
            } else{
                return i;
            }
        }
        return -1;

    }
}
