package List;

class LinkedNode {
     public int data;
     public LinkedNode next = null;
     public LinkedNode(int elem) {
          this.data = elem;
     }
}
public class linkedList {
     private LinkedNode head = null;
     //头插法
     public void addFirst(int elem){
          LinkedNode node = new LinkedNode(elem);
          if(this.head == null){
               this.head = node;
               return;
          }
          node.next = head;
          this.head = node;
          return;
     }
     // 尾插法

     public void addLast(int elem){
          LinkedNode node = new LinkedNode(elem);
          if(this.head == null){
               this.head = node;
               return;
          }
          LinkedNode cur = this.head;
          while(cur.next != null){
               cur = cur.next;
          }
          cur.next = node;
     }
     // 按下标找元素
     public int size(){
          LinkedNode prev = this.head;
          int count = 0;
          while (prev.next != null){
               prev = prev.next;
               count++;
          }
          return count;
     }
     // 得到index-1的位置
     private LinkedNode getIndex(int index){
          LinkedNode prev = this.head;
          for(int i = 0;i < index; i++){
               prev = prev.next;
          }
          return prev;
     }
     // 根据下标去插入元素
     public boolean addIndex(int index, int elem){
          LinkedNode node = new LinkedNode(elem);
          int len = size();
          if(index < 0 || index > len ){
               return false;
          }
          if(index == 0){
              addFirst(elem);
               return true;
          }
          if(index == len){
               addLast(elem);
               return true;
          }
          LinkedNode prev = getIndex(index-1);
          node.next = prev.next;
          prev.next = node;
          return true;
     }
     //判断是否存在关键字 key
     public boolean contains(int key){
          LinkedNode node = this.head;
          if(node == null){
               return false;
          }
          while(node.next != null){
               if(node.data == key){
                    return true;
               }
               node = node.next;
          }
          return false;
     }

     //删除第一次出现关键字Key的节点

     public void remove(int key){
          //处理不存在key
//          if(contains(key) == false){
//               return;
//          }
          //处理链表为空时
          if(this.head == null){
               return;
          }
          //处理删除第一个节点时
          if(head.data == key){
               this.head = this.head.next;
          }
          //删除中间节点时
          LinkedNode node = this.head;
          while (node.next != null){
               if(node.next.data == key){
                    node.next = node.next.next;
                    return;
               }
               node = node.next;
          }
          return;
     }

     //删除所有值为key的节点
     public void removeAllKey2(int key) {
          LinkedNode prev = this.head;
          LinkedNode cur = prev.next;
          //         //链表为空时
          if(this.head == null){
               return;
          }
          while(cur != null){
               if(cur.data == key){
                    prev.next = cur.next;
                    cur = prev.next;
               } else{
                    // prev = cur;
                    //cur = cur.next;
                    prev = prev.next;
                    cur = prev.next;
               }
          }
          if(head.data == key){
               head = head.next;
          }
          return;
     }
     //删除所有值为key的节点
     public void removeAllKey(int key) {
         LinkedNode node = this.head;
          //         //链表为空时
         if(this.head == null){
              return;
         }
         //删除第一个节点
         while (node.next != null){
               while (node.data == key && node.next != null){
                    node = node.next;
               }
               if(node.data != key){
                    head = node;
               }
               if( node.data == key && node.next == null){
                    head = null;
                    return;
               }
               while (node.next != null){
                    if(node.next.data == key){
                         node.next = node.next.next;
                    }
                    else {
                         node = node.next;
                    }
               }
              return;
         }
     }
     //清空链表
     public void clear(){
          this.head = null;
          return;
     }
     // 打印链表
     public void display(){

          System.out.print("[");
          for(LinkedNode node = this.head; node != null
                  ; node = node.next){
               System.out.print(node.data);
               if(node.next!=null){
                    System.out.print(",");
               }
          }
          System.out.println("]");
     }

}
