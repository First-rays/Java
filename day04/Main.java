package day04;

import java.util.Scanner;
public class Main{
    //删除公共字符
//    public static void main(String []args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            StringBuffer sb = new StringBuffer(s1);
//            int count = -1;
//            for(int i = 0; i < s1.length(); i++){
//                int flag = 0;
//                for(int j = 0; j < s2.length(); j++){
//                    if(s1.charAt(i) == s2.charAt(j)){
//                        flag = 1;
//                        count++;
//                        break;
//                    }
//                }
//                if(flag == 1){
//                    sb = sb.deleteCharAt(i-count);
//                }
//
//            }
//            System.out.print(sb.toString());
//
//        }
//    }
//2. 买苹果
//    public static void main(String []args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int count = sc.nextInt();
//            int indexLength = count / 6;
//            int []array = new int[indexLength];
//            for(int i = 0; i < indexLength; i++){
//                if((count - i*6)%8 == 0){
//                    array[i] = i + (count - i*6)/8;
//                } else{
//                    array[i] = -1;
//                }
//                if((count % 6) == 0 && array[i] == -1) {
//                    array[i] = count / 6;
//                }
//                if((count % 8) == 0 && array[i] == -1) {
//                    array[i] = count / 8;
//                }
//            }
//            int min = 0;
//            int index = 0;
//            int count1 = 0;
//            for(int i = 0; i < indexLength; i++){
//                if(array[i] != -1){
//                    count1++;
//                    index = i;
//                }
//            }
//            if(count1 == 1){
//                System.out.println(array[index]);
//                return;
//            }
//            for(int j = 1; j < indexLength; j++){
//                if(array[min] > array[j] && array[j] != -1){
//                    min = j;
//                }
//            }
//            System.out.print(array[min]);
//
//
//        }
//    }

    public static void main(String[] args) {
        int x;
        int y;
        x=5>>2;
        y=x>>>2;
        System.out.println(5<<2);
        System.out.println(5>>2);
        System.out.println(y);
    }
}
