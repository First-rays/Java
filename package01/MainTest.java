package package01;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            StringBuffer stringBuffer = new StringBuffer(A);
            stringBuffer.insert(i,B);
            if(huiwenshu(stringBuffer.toString())){
                count++;
            }
        }
        System.out.println(count);

    }
    public static boolean huiwenshu(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
