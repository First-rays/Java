package package1204;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while(scanner.hasNext("0")){
            String str = scanner.nextLine();
            str = str.toUpperCase();
            hashSet.add(str);
        }
        System.out.println(hashSet.size());
        return;
    }
}