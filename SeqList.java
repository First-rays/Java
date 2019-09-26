package List;
public class SeqList {
    int[] data = new int[10];
    private int size = 0;
    //打印顺序表
    public void display(){
        System.out.print("[");
        for(int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if(i < size-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //在pos位置新增元素
    public void add(int pos, int element){
        if(pos < 0 || pos > size){
            return;
        }
        if(size > data.length){
            System.out.println("空间不够，需扩容！已经按原空间2倍扩容");
            expendCapacity();
        }
        if(pos == size) {
            this.data[pos] = element;
        }
        for(int i = size - 1; i >= pos; i--) {
            data[i+1] = data[i];
        }
        data[pos] = element;
        size++;
    }

    //查找是否包含某个元素
    public boolean contains(int tofind) {
        return search(tofind)!= -1;
    }
    //查找某个元素的位置
    public int search(int tofind){
        for(int i = 0;i < size; i++){
            if(data[i] == tofind){
                return i;
            }
        }
        return -1;
    }

    //获取某个位置的元素
    public int getPos(int pos){
        return data[pos];
    }

    //给pos位置的元素设为value
    public void setPos(int pos, int value) {

        data[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(search(toRemove)==-1){
            return;
        }
        for(int i = search(toRemove); i<size - 1; i++){
            data[i] = data[i+1];
        }
        size--;
    }
    //获取顺序表长度
    public int size(){
        return size;
    }
    //清空顺序表
    public void clear(){
        size = 0;
    }

    // 扩容顺序表
    protected void expendCapacity(){
        int[] newdata = new int [data.length*2];
        for(int i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }
}
