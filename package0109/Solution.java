package package0109;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
    // 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
    // 如果可以构成，返回 true ；否则返回 false
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            hashMap1.put(magazine.charAt(i),
                    hashMap1.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i = 0; i < magazine.length(); i++){
            hashMap2.put(magazine.charAt(i),
                    hashMap2.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int j = 0; j < ransomNote.length(); j++){
            if(hashMap2.containsKey(ransomNote.charAt(j)) ){
                if(hashMap1.get(ransomNote.charAt(j)) >
                        hashMap2.get(ransomNote.charAt(j))){
                    return false;
                }
            } else{
                return false;
            }
        }
        return true;
    }

    //判断一个整数是否是回文数。回文数是指正序（从左向右）
    // 和倒序（从右向左）读都是一样的整数。

    public boolean isPalindrome(int x) {
        int n = x;
        int sum = 0;
        if(x < 0){
            return false;
        }
        while(x != 0){
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return sum == n;
    }
}
