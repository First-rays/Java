package data_structure;

import java.util.Stack;

public class Solution3 {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public void push(int x) {
        while (!B.empty()){
            int ret = B.pop();
            A.push(ret);
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(A.isEmpty() && B.isEmpty()){
            return 0;
        }
        while (!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(A.isEmpty() && B.isEmpty()){
            return 0;
        }
        while (!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
