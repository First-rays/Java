package data_structure;

import java.util.LinkedList;

public class Solution2 {
//    public MyStack() {
//         LinkedList<Integer> A = new LinkedList<>();
//        LinkedList<Integer> B = new LinkedList<>();
//    }
    //用队列实现栈
    LinkedList<Integer> A = new LinkedList<>();
    LinkedList<Integer> B = new LinkedList<>();
    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(A.isEmpty()){
            return 0;
        }
        while (A.size() > 1){
            int ret = A.removeFirst();
            B.addLast(ret);
        }
        int cur = A.removeFirst();
        swap();
        return cur;
    }
    private void swap(){
        LinkedList<Integer> tem = A;
        A = B;
        B = tem;
    }
    /** Get the top element. */
    public int top() {
        if(A.isEmpty()){
            return 0;
        }
        while (A.size() > 1){
            int ret = A.removeFirst();
            B.addLast(ret);
        }
        int cur = A.removeFirst();
        B.addLast(cur);
        swap();
        return cur;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }
}
