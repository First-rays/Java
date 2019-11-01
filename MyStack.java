package data_structure;

public class MyStack {
    private int []data = new int[100];
    private int size = 0;
    public void push(int x){
        if(size == 100){
            return;
        }
        data[size] = x;
        size++;
        return;
    }
    public Integer pop(){
        if(size == 0){
            return null;
        }
        Integer ret = data[size - 1];
        size--;
        return ret;
    }
    public Integer peek(){
        if(size == 0){
            return null;
        }
        return data[size -1];
    }
    public boolean Isempty(){
        return size == 0;
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        while(!myStack.Isempty()){
           // myStack.peek();
            System.out.println(myStack.pop());

        }
    }
}
