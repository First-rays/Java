package day14;

import java.util.Arrays;

public class Main {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static int getValue(int[] gifts, int n) {
        // write code here
        Arrays.sort(gifts);
        if(gifts[n/2 -1] != gifts[n/2] || gifts[n/2]!=gifts[n/2 +1]){
            return 0;
        } else{
            return gifts[n/2];
        }
    }

    public static void main(String[] args) {
        int []a = {1,1};
        System.out.println(getValue(a,2));
    }

    //链表根据 x 分割
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null){
            return null;
        }

        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-1);
        ListNode cur = pHead;
        ListNode ps = node1;
        ListNode pb = node2;
        while (cur != null){
            if(cur.val < x){
                ps.next = new ListNode(cur.val);
                ps = ps.next;
                cur = cur.next;
            } else{
                pb.next = new ListNode(cur.val);;
                pb = pb.next;
                cur = cur.next;
            }
        }
        pb.next = null;
        ps.next = node2.next;

        return node1.next;


    }


}
