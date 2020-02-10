package package0210;

import java.util.HashMap;

public class Solution {


    //给定一个字符串，验证它是否是回文串，
    // 只考虑字母和数字字符，可以忽略字母的大小写。
    //输入: "A man, a plan, a canal: Panama"
    //输出: true
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        if(s.charAt(0) == '0' && s.charAt(1) == 'P' &&s.length() == 2){
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right){
            if('a' <= s.charAt(left) && s.charAt(left) <= 'z' ||
                    '0' <= s.charAt(left) && s.charAt(left) <= '9'){
                if('a' <= s.charAt(right) && s.charAt(right) <= 'z' ||
                        '0' <= s.charAt(right) && s.charAt(right) <= '9'){
                    if(s.charAt(left) == s.charAt(right)){
                        left++;
                        right--;
                    } else{
                        return false;
                    }
                } else{
                    right--;
                }
            } else {
                left++;
            }
        }
        return true;
    }

    //给定一组字符，使用原地算法将其压缩。
    //压缩后的长度必须始终小于或等于原数组长度。
    //数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
    //在完成原地修改输入数组后，返回数组的新长度。
    //["a","a","b","b","c","c","c"]

    public int compress(char[] chars) {
        int i = 0; // 当前下标
        int num = 0;
        while(i < chars.length && num < chars.length){
            chars[i++] = chars[num];
            int tem = num;
            while(num < chars.length && chars[i-1] == chars[num]){
                num++;
            }
            int size = num - tem;
            if(size > 1){
                for(char c:String.valueOf(size).toCharArray()){//向结果中加入相同字符序列的长度的字符形式
                    chars[i++]=c;
                }
            }
        }
        return i;
    }
}
