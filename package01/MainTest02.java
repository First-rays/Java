package package01;

import java.util.Scanner;

public class MainTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = {1,3,5,2,2};
        int n = array.length;
        int k = 3;
        System.out.println(topK(array, n, k));
    }
    private static int topK(int[] array, int n , int k){
        return topKhelper(array, 0, n, k);
    }

    private static int topKhelper(int []array, int low, int high, int k){
        int tem = partition(array, low, high - 1);
        if(tem - low + 1 == k){
            return array[tem];
        } else if(k < tem - low + 1 ){
            return topKhelper(array, low, tem - 1, k);
        } else{
            return topKhelper(array, tem + 1, high, k - tem + low - 1);
        }
    }
    private static int partition(int []array, int left, int right){
        int key = array[left];
        while (left < right){
            while (left < right && array[right] <= key){
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] >= key){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
}
