package day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/*
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int tem = in.nextInt();
                list.add(tem);
            }
            int number = in.nextInt();
            if(list.contains(number)){
                System.out.println(list.indexOf(number));
            } else{
                System.out.println("-1");7772160.196608.768.193

            }
        }
    }
}
*/
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String s1 = in.next();
            String ss[] = s.split("\\.");
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < ss.length; i++){
                String str = ss[i];
                stringBuffer.append(changeTo2(parseInt(str)));
            }
            String s2 = stringBuffer.toString();
            System.out.println(changeToInt(s2));

            String s3 = changeTo22(parseInt(s1));
            System.out.println(ipAddress(s3));


        }
    }

    private static String ipAddress(String s3){
        int sum = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int j = 0;
        for(int i = 1; i <= 4; i++){
            for(; j < 8*i; j++){
                int tem = s3.charAt(j) - '0';
                sum += tem * Math.pow(2,7-(j%8));
                if((j+1) % 8 == 0){
                    stringBuffer.append(sum+".");
                    sum = 0;
                }
            }
            j = 8*i;
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        return stringBuffer.toString();
    }

    private static String changeTo22(long num){
        StringBuffer stringBuffer = new StringBuffer("00000000000000000000000000000000");
        int i = 0;
        while(num != 0){
            long tem = num % 2;
            stringBuffer.setCharAt(i,(char)(tem+48));
            num /= 2;
            i++;
        }
        return stringBuffer.reverse().toString();
    }

    private static String changeTo2(int num){
        StringBuffer stringBuffer = new StringBuffer("00000000");
        int i = 0;
        while(num != 0){
            int tem = num % 2;
            stringBuffer.setCharAt(i,(char)(tem+48));
            num /= 2;
            i++;
        }
        return stringBuffer.reverse().toString();
    }
    private static long changeToInt(String s){
        long sum = 0;
        for(int i = 0; i <=31; i++){
            int tem = s.charAt(i) - '0';
            sum += tem * Math.pow(2,31-i);
        }
        return sum;
    }
}