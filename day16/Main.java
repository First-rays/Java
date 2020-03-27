package day16;

import java.util.ArrayList;
import java.util.Scanner;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    //ppRYYGrrYBR2258
    //YrR8RrY

    //Yes 8
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s1 = in.next();
            String s2 = in.next();
            int num = 0; // 缺少的珠子
            ArrayList<Character> arrayList = new ArrayList<>();
            for(int i =0; i < s1.length(); i++){
                arrayList.add(i,s1.charAt(i));
            }
            //StringBuffer stringBuffer = new StringBuffer(s1);
            for(int i = 0; i < s2.length(); i++){
                if(arrayList.contains(s2.charAt(i))){
                    arrayList.remove(arrayList.indexOf(s2.charAt(i)));
                    num++;
                }
            }
            if(num != s2.length()){
                System.out.println("No"+" " +(s2.length()-num));
            } else{
                System.out.println("Yes"+" "+arrayList.size());
            }
        }
    }


    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode p1 = a;
        ListNode p2 = b;
        int sum = 0;
        while(p1 != null || p2 !=null || sum != 0){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10;
            //cur = cur.next;
            cur = cur.next;
        }

        return head.next;

    }
}
