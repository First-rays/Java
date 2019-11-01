package data_structure;

class Node{
     int val;
     Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public void offer(int x){
        if(head == null){
            tail = new Node(x);
            head = tail;
        } else{
            tail.next = new Node(x);
            tail = tail.next;
        }
        size++;
        return;
    }
    public Integer poll(){
        if(head == null){
            return null;
        }
        Integer ret = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return ret;
    }
    public Integer peek(){
        if( head == null){
            return null;
        }
        return head.val;
    }
    public boolean IsEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        while(!myQueue.IsEmpty()){
            System.out.println(myQueue.poll());
        }

    }
}
