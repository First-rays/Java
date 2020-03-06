package day02;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.Stack;
//汽水瓶问题
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int number = 0;
//        while (in.hasNext()) {
//            number = in.nextInt();
//            if(number == 0){
//                break;
//            }
//        }System.out.println(max(number));
//    }
//    private static int max(int number){
//        int count = 0;
//        int empty = number;
//
//        while(empty >= 3){
//            count += (empty/3);
//            empty = empty%3 + empty/3;
//            if(empty == 2){
//                empty += 1;
//            }
//        }
//        return count;
//    }
//
//}
//2.数组逆序对
//public class Main{
//    public static int count(int[] A, int n) {
//        // write code here
//        int countNum =0;
//        int j = 0;
//        for(int i = 0;i < n-1;i++){
//            if(A[i]>A[i+1]){
//                countNum += i + 1 - j;
//                j = i;
//            }
//        }
//        return countNum;
//
//    }
//
//    public static void main(String[] args) {
//        int a[]={1,2,3,41,5,6,7};
//
//        System.out.println(count(a,a.length));
//    }
//}

class Base{
     String name = "Person";
    int age = 0;
}

//public class Main{
//
//    //abcd12345ed125ss123456789
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        StringBuffer stringBuffer = new StringBuffer("");
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
//                stringBuffer.append(s.charAt(i));
//            } else if(s.charAt(i)== ' '){
//                break;
//            } else{
//                stringBuffer.append(" ");
//            }
//        }
//        String strings[] = stringBuffer.toString().split(" ");
//        if(strings.length == 0){
//           throw new IndexOutOfBoundsException();
//        }
//        int maxLength = 0;
//        int j = 0;
//        for(; j < strings.length; j++){
//            if(strings[maxLength].length()<strings[j].length()){
//                maxLength = j;
//            }
//        }
//        System.out.println(strings[maxLength]);
//    }
//
//    public static boolean chkParenthesis(String A, int n) {
//        // write code here
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < n; i++){
//            if(A.charAt(i) != '(' && A.charAt(i) != ')'){
//                return false;
//            }
//            if(A.charAt(i) == '('){
//                stack.add(A.charAt(i));
//            } else if(A.charAt(i) == ')' && stack.size() != 0){
//                stack.pop();
//            } else{
//                return false;
//            }
//        }
//        if(stack.size() == 0){
//            return true;
//        }
//        return false;
//    }

//    public static void main(String[] args) {
//        String s = "(()())";
//
//        System.out.println(chkParenthesis(s,6));
//    }
//}
