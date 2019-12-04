package package1204;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();
            int y3 = sc.nextInt();
            int y4 = sc.nextInt();
            int x1 = y2 + y4;
            int B = x1 / 2;
            int A = y3 - B;
            int C = y4 - B;
            if(((A-B) == y1) && ((B - C) == y2) &&((A +B == y3)) &&((B+C ) == y4)){
                System.out.println(A + " " + B + " " + C);
            } else{
                System.out.println("No");
            }
            return;
        }
    }
}
