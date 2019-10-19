package List;

class DlinkedNode{
    public int data = 0;
    public DlinkedNode next;
    public DlinkedNode prev;

    public DlinkedNode(int data) {
        this.data = data;
    }
}
public class DlinkedList {
    DlinkedNode head = null;
    DlinkedList(){
        head = new DlinkedNode(-1);
        head .next = head;
        head.prev = head;
    }
    //头插法
    public  void addFirst(int elem){
       DlinkedNode newNode =new DlinkedNode(elem);
       DlinkedNode next = head.next;
       head.next = newNode;
       newNode.prev = head;

       newNode.next = next;
       next.prev = newNode;
       return;
    }
    //打印链表
    public void display(){
        DlinkedNode node = head.next;
        System.out.print("正向：[");
        while(node != head){
            System.out.print(node.data);
            if(node.next != head){
                System.out.print(",");
            }
            node = node.next;
        }
        System.out.println("]");
        node =node.prev;
        System.out.print("反向：[");
        while(node != head){
            System.out.print(node.data);
            if(node.prev != head){
                System.out.print(",");
            }
            node = node.prev;
        }
        System.out.println("]");
    }
    //尾插
    public void addList(int elem){
        DlinkedNode newNode = new DlinkedNode(elem);
        DlinkedNode tail = head.prev;
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        return;
    }
    //按下标插入指定元素
    public void addIndex(int index, int elem){
        DlinkedNode newNode = new DlinkedNode(elem);
        int size = size();
        if(index < 0 || index > size){
            return;
        }
        if(index == 0){
            addFirst(elem);
            return;
        }
        if(index == size){
            addList(elem);
            return;
        }
        DlinkedNode next = getPos(index);
        DlinkedNode prev = next.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
    }

    public  DlinkedNode getPos(int index){
        DlinkedNode cur = head.next;
        for(int i =0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }

    //求链表长度
    public  int size() {
        int size = 0;
        for(DlinkedNode cur = head.next;
                cur != head; cur = cur.next){
            size++;
        }
        return size;
    }
    //查找链表中是否包含某个元素
    public boolean contains(int key){
        DlinkedNode cur = head.next;
        while(cur != head){
            if(cur.data == key){
                return true;
            }
        }
        return false;
    }
    //删除第一次出现关键字Key的节点
    public void remove(int key){
        DlinkedNode cur = find(key);
        if(cur == null){
            return;
        }
        DlinkedNode prev = cur.prev;
        DlinkedNode next = cur.next;

        prev.next = next;
        next.prev = prev;

    }
    //根据元素找到对应的节点
    public DlinkedNode find(int key){
        DlinkedNode cur = head.next;
        while(cur != head){
            if(cur.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除所有出现的关键字key
    public void removeAll(int key){
        while(true){
            DlinkedNode cur = find(key);
            if(cur == null){
                return;
            }
            DlinkedNode prev = cur.prev;
            DlinkedNode next = cur.next;

            prev.next = next;
            next.prev = prev;
        }
    }
    //清空链表
    public void clear(){
        head.prev = head;
        head.next = head;

    }
}
