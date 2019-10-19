package List;

public class runDlinkedList {
    public static void main(String[] args) {
       DlinkedList list = new DlinkedList();
       System.out.println("测试头插：");
       list.addFirst(1);
       list.addFirst(2);
       list.addFirst(3);
       list.addFirst(4);
       list.display();
       System.out.println("测试尾插：");
       list.addList(5);
       list.addList(6);
       list.addList(7);
       list.addList(8);
       list.addList(8);
       list.addList(8);
       list.display();
       System.out.println("测试按下标添加元素：");
       list.addIndex(3,100);
       list.display();
       System.out.println("测试删除第一个关键字：");
       list.remove(100);
       list.display();
       System.out.println("测试删除链表中的所有关键字：");
       list.removeAll(8);
       list.display();
    }
}
