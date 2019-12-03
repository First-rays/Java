package package02;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (scanner.hasNext()){
            n = scanner.nextInt();
            System.out.println(drink(n));
        }
    }
    private static int drink(int n){
        int count = 0;
        while (n > 2){
            count = count + n /3;
            n = n / 3 + n % 3;
        }
        if(n == 2){
            count += 1;
        }
        return count;
    }

}
