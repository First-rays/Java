package day19;


import java.util.Arrays;
import java.util.Scanner;
//
//public class Main{
//
//    public static void main(String []args){
//        Scanner  in = new Scanner(System.in);
//        while(in.hasNext())
//        {
//            String s = in.nextLine();
//            String ss[] = s.split(" ");
//            for(int i = ss.length-1; i>= 0;i--){
//                System.out.print(ss[i]);
//                if(i != 0){
//                    System.out.print(" ");
//                }
//            }
//        }
//
//    }
import java.util.Arrays;
import java.util.Scanner;
/*
public class Main{

    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        while(in.hasNext())
        {
            int n = in.nextInt();
            int x = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int count = 0;
            int i = arr.length -1;
            int min = arr[0];
            int max = arr[i];
            while (max - min > x){
                max = arr[--i];
                count++;
            }
            System.out.println(count);

        }
    }


}

/*
public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            int sum = 0;
            int count = 0;
            while(sum <= m){
                for(int i = 0; i < n; i++){
                    sum += arr[i];
                    count++;
                    if(sum >= m){
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
*/

import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int a[] = new int[N];
            double p[] = new double[N];

            for(int i = 0; i < N; i++){
                p[i]= in.nextDouble();
            }
            for(int i = 0; i < N; i++){
                a[i]= in.nextInt();
            }
            double result = 0;
            double r = a[0]*p[0];
            for(int i = 0; i < N; i++){
                result += r;
                r *= p[0];
            }
            double max = 0;
            for(int i = 0; i < N; i++){
                max += r;
                r *= p[i];
            }
            if(result>=max)
            System.out.printf("%.2f",result);
            else
                System.out.printf("%.2f",max);
        }
    }
}

