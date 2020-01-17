package package0117;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    //你的朋友正在使用键盘输入他的名字 name。偶尔，
    // 在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次
    public boolean isLongPressedName(String name, String typed) {
        return true;
    }

    //给定一个按非递减顺序排序的整数数组 A，
    // 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            int tem = A[i] * A[i];
            A[i] = tem;
        }
        Arrays.sort(A);
        return A;
    }

    //给定一个字符串 S，返回 “反转后的” 字符串，
    // 其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    public String reverseOnlyLetters(String S) {
        char []ch = S.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while(left <= right){
            if(ch[left] >= 'A' && ch[left] <= 'Z' ||
                    ch[left] >= 'a' && ch[left] <= 'z'){
                if(ch[right] >= 'A' && ch[right] <= 'Z' ||
                        ch[right] >= 'a' && ch[right] <= 'z'){
                    char tem = ch[left];
                    ch[left] = ch[right];
                    ch[right] = tem;
                    left++;
                }
                right--;
            } else{
                left++;
            }

        }
        return new String(ch);
    }

    //给定一个非负整数数组 A，返回一个数组，
    // 在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left <= right){
            if(A[left] % 2 == 1){
                if(A[right] % 2 != 1){
                    int tem = A[left];
                    A[left] = A[right];
                    A[right] = tem;
                } else{
                    right--;
                }
            } else {
                left++;
            }
        }
        return A;
    }


}