package package02;

import java.util.Scanner;

public class MainTest02 {
    public static void main(String[] args) {
        int []array ={100,2,3,4,5,6,7,8};
        int n = array.length;
        System.out.println(nixudui(array, n));
    }
    private static int nixudui(int[] array, int n){
        int count = 0;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
