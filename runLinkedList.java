package List;

public class runLinkedList {
    public static void main(String[] args) {
        linkedList node = new linkedList();
        node.addFirst(4);
        node.addFirst(3);
        node.addFirst(1);
        node.addFirst(1);
        node.addLast(1);
        node.addLast(3);
        node.addLast(1);
        node.addLast(1);
        node.addIndex(3,11);
        node.display();
        System.out.println(node.contains(10));
        node.remove(10);
        node.display();
        node.removeAllKey(1);
        node.removeAllKey2(3);
        node.display();

    }
}
