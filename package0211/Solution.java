package package0211;

public class Solution {


    //给定一个整数数组，你需要寻找一个连续的子数组，
    // 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //你找到的子数组应是最短的，请输出它的长度。
    //输入: [2, 6, 4, 8, 1, 9, 15]
    //输出: 5
    //解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

    public int findUnsortedSubarray(int[] nums) {
        int numbers = 0;
        int flag = 0;
        for(int i = 0; i < nums.length - 1; i++){
            flag = 0;
            for(int j = i + 1; j <=nums.length; j++){
                if(nums[i] > nums[j]){
                    flag = 1;
                   break;
                }
            }
            if(flag == 1){
                numbers++;
            }
        }
        return numbers;
    }
}
