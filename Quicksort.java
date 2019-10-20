package sort;

public class Quicksort {
    public static void main(String[] args) {
        int []num = {1,5,0,9,3,7,8,4,2};
        int left = 0;
        int right = num.length - 1;
        quickSort(num, left, right);
        for (int num1 : num) {
            System.out.print(num1 +"    ");
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
