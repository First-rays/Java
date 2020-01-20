package package0120;

public class Solution {

    //给定一个按照升序排列的整数数组 nums，
    // 和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int []arr = new int[2];
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                if(mid != 0 && nums[mid - 1] == target){
                    arr[0] = mid - 1;
                    arr[1] = mid;
                    break;
                } else if(mid != nums.length && nums[mid + 1] == target){
                    arr[0] = mid;
                    arr[1] = mid + 1;
                    break;
                }
                if(mid == 0){
                    arr[0] = 0;
                    arr[1] = 1;
                    break;
                }
                if(mid == nums.length - 1){
                    arr[0] = nums.length - 1;
                    arr[1] = nums.length - 1 - 1;
                    break;
                }
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return arr;
    }

    public int[] searchRange2(int[] nums, int target){
        int result[] = {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else{
                int fl = mid;
                while(nums[mid] == target){
                    result[0] = mid;
                    --mid;
                    if(mid == -1){
                        break;
                    }
                }
                while(nums[fl] == target){
                    result[1] = fl;
                    ++fl;
                    if(fl == nums.length){
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }

}
