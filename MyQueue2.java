package data_structure;

public class MyQueue2 {
    private int []data = new int [100];
    private int head = 0;
    private int tail = 0;
    int size = 0;
    public boolean offer(int x){
        if(size == data.length){
            return false;
        }
        data[tail] = x;
        tail++;
        size++;
        if(tail == data.length){
            tail = 0;
        }
        return true;
    }

    public Integer poll(){
        if(size == 0){
            return null;
        }
        Integer ret = data[head];
        head++;
        if(head == data.length){
            head = 0;
        }
        size--;
        return ret;

    }

    public Integer peek(){
        if(size == 0){
            return null;
        }
        return data[head];
    }
    public boolean IsEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        while(!myQueue2.IsEmpty()){
            System.out.println(myQueue2.poll());
        }
    }
}
