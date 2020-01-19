package package0119;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    //给定一个整数数组 nums 和一个目标值 target，
    // 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
            }
        }
        return arr;
    }
    //给定两个二进制字符串，返回他们的和（用二进制表示）。
    //输入为非空字符串且只包含数字 1 和 0。
    //输入: a = "1010", b = "1011"
    //输出: "10101"
    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int tem = 0;
        for(int i = a.length(); i >= 0; i--){
            for(int j = b.length(); j >= 0; j--){

            }
        }
        return stringBuffer.toString();
    }


}
