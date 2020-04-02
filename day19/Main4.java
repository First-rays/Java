package day19;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    //abcabcabc
    //2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            int n = in.nextInt();
            int a[] = new int [n];
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            for(int i = 0; i < n-1; i++){
                for(int j = 1; j < n; j++){
                    arrayList.add(a[i]^a[j]);
                }
            }
            int result = 0;
            for(int i = 0; i < arrayList.size(); i++){
                result ^=arrayList.get(i);
            }
            System.out.println(result);
        }

    }

}
