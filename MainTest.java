package sort;

import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {
        int array[] = {5, 4, 7, 8, 6, 3, 1, 1111,1,1};
        //insertSort(array);
        shellSort(array);
        //selectSort(array);
        System.out.println(Arrays.toString(array));
    }
    //插入排序
    public static void insertSort(int[] array){
        int bound = 1;
        for(; bound < array.length; bound++){
            int key = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur-- ){
                if(array[cur] > key){
                    array[cur + 1] = array[cur];
                } else{
                    break;
                }
            }
            array[cur + 1] = key;
        }
    }

    //希尔排序
    public static void shellSort(int[] array){
        int group = array.length;
        while(group >= 1){
            shellSorHelp(array,group);
            group = group / 2;
        }
        //shellSorHelp(array, 1);
    }
    public static void shellSorHelp(int[] array, int group){

        for(int bound = 1; bound < array.length; bound += group){
            int key = array[bound];
            int cur = bound - group;
            for(;cur >= 0; cur -= group){
                if(array[cur] > key){
                    array[cur + group] = array[cur];
                } else{
                    break;
                }
            }
            array[cur + group] = key;
        }
    }


    //直接选择排序

    public static void selectSort(int[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = bound + 1; cur < array.length ;cur++){
                if(array[bound] > array[cur]){
                    swap(array ,bound ,cur);
                }
            }
        }

    }
    public static void quickSort(int []num ,int left, int right){
        int flagNum;
        if(left < right){
            flagNum = partion(num, left, right);
            quickSort(num, left,flagNum-1);
            quickSort(num,flagNum+1, right);
        }
    }
    public static int partion(int []num ,int left, int right){
        int key ;
        int mid = (left + right) / 2;
        if(num[left] > num[right]){
            swap(num, left, right);
        }
        if(num[mid] > num[right]){
            swap(num, mid, right);
        }
        if(num[left] < num[mid]){
            swap(num, left,mid);
        }
        key = num[left];
        while(left < right){
            while(left < right && num[right]>= key){
                right--;
            }
            //swap(num,left, right);
            num[left] = num[right];
            while(left < right && num[left] < key){
                left++;
            }
            //swap(num,left, right);
            num[right] = num[left];
        }
        num[left] = key;
        return left;
    }
    public static void swap(int []num, int l, int r){
        int t = num[l];
        num[l] = num[r];
        num[r] = t;
        return;
    }
}
