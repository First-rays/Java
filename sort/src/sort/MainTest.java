package sort;

import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;

public class MainTest {

    public static void main(String[] args) {
        int array[] = {5, 4, 7, 8, 6, 3, 1, 1111,1};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //quickSort2(array,0,array.length-1);
        //quickSortByLoop(array);
        //mergeSort(array);
        //mergeSortByLoop(array);
        quickSort3(array,0,array.length-1);
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
    //冒泡排序
    public static void buddleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 -i; j++){
                if (array[j+1] > array[j]) {
                    swap(array, j+1, j);
                }
            }
        }
    }

    //直接选择排序

    public static void selectSort(int[] array){
        for(int bound = 0; bound < array.length - 1; bound++){
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

    //堆排序
    public static void heapSort(int []array){
        //建堆
        creatHeap(array);
        //升序排列建大堆，然后第一个和最后一个交换
        for(int i = 0; i < array.length; i++){
            swap(array, 0, array.length -1 - i);
            //每一次交换完成后，需要先下转换，确保是正确的大堆
            //第一个数据是数组，第二个数据是数组中的有效元素的个数
            //第三个是向下调整开始的下标
            shiftDown(array, array.length - i -1, 0);
        }
    }
    private static void creatHeap(int []array){
        //从第一个非叶子节点开始向下调整
        for(int i = (array.length - 1 -1)/2; i >= 0; i--){
            shiftDown(array, array.length, i);
        }
    }
    private static void shiftDown(int []array, int size, int index){
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            if(child + 1 < size && array[child + 1] > array[child]){
                child = child + 1;
            }
            if(array[child] > array[parent]){
                swap(array, child, parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //快速排序
    public static void quickSort2(int []array, int left, int right){
        int flagNum;
        if(left < right){
            flagNum = partion2(array, left, right);
            quickSort2(array, left, flagNum - 1);
            quickSort2(array, flagNum + 1, right);
        }
    }
    public static int partion2(int []array, int left, int right){
        int key = array[left];
        while (left < right){
            while (left < right && array[right] >= key){
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < key){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
    //    // 非递归版本的快速排序
        public static void quickSortByLoop(int[] array) {
            // 1. 先创建一个栈, 栈里面存的是待处理区间的下标
            Stack<Integer> stack = new Stack<>();
            // 2. 初始情况下待处理区间, 就是整个数组
            stack.push(array.length - 1);
            stack.push(0);
            while (!stack.isEmpty()) {
                // 3. 取栈顶元素, 栈顶元素就是我们要处理的区间
                int left = stack.pop();
                int right = stack.pop();
                if (left >= right) {
                    continue;
                }
                // 4. 对当前待处理区间进行整理
                int index = partion(array, left, right);
                // 5. 接下来要处理的区间再入栈
                // [left, index - 1]
                // [index + 1, right]
                stack.push(index - 1);
                stack.push(left);

                stack.push(right);
                stack.push(index + 1);
            }
        }

        //归并排序
 public static void mergeSort(int[] array){
        mergeSortHelp(array, 0, array.length);
    }
    private static void mergeSortHelp(int[] array, int left, int right){
        if(left >= right || right - left == 1){
            return;
        }
        int mid = (right + left) / 2;
        mergeSortHelp(array, left, mid);
        mergeSortHelp(array, mid,right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right){
        int length = right - left;
        int output[] = new int[length];
        int outputindex = 0;
        int i = left;
        int j = mid;
        while(i < mid && j < right){
            if(array[i] <= array[j]){
                output[outputindex++] = array[i++];
            } else{
                output[outputindex++] = array[j++];
            }
        }
        while (i < mid){
            output[outputindex++] = array[i++];
        }
        while(j < right){
            output[outputindex++] = array[j++];
        }
        for(int k = 0; k < length; k++){
            array[k + left] = output[k];
        }
    }

    //非递归版本的归并排序

    public static void mergeSortByLoop(int[] array) {
        // 借助下标相关的规律来进行分组.
        // 初始情况下, 每个元素单独作为一组
        // [0] [1]    [2] [3]     [4] [5]
        // [0, 1] 和 [2, 3] 合并. [4, 5]  和 [6, 7] 区间合并
        // [0, 1, 2, 3]  [4, 5, 6, 7]
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                // 这个循环负责在 gap 为指定值的情况下
                // 把所有的区间进行归并
                // 针对当前的 i, 也能划分出两个需要进行归并的区间
                // [beg, mid)
                // [mid, end)
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (end > array.length) {
                    end = array.length;
                }
                merge(array, beg, mid, end);
            }
        }
    }
    public static void swap(int []num, int l, int r){
        int t = num[l];
        num[l] = num[r];
        num[r] = t;
    }

    public static void quickSort3(int []array, int left, int right){
        int partitionNum;
        if(left < right){
            partitionNum = partition(array,left,right);
            quickSort3(array, left, partitionNum -1);
            quickSort3(array,partitionNum + 1, right);
        }
    }
    private static int partition(int[]array, int left, int right){
        int key = array[left];
        while(left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < key) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
}
