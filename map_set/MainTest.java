package map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
public class MainTest {

    //给定一个非空整数数组，除了某个元素只出现一次以外，
    // 其余每个元素均出现两次。找出那个只出现了一次的元素。
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer x : nums){
           Integer count = map.getOrDefault(x, 0);
           map.put(x, count + 1);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
    //给定一个链表，每个节点包含一个额外增加的随机指针，
    // 该指针可以指向链表中的任何节点或空节点。
    //要求返回这个链表的深拷贝
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashMap = new HashMap<>();
        //HashMap里 key 存着旧的节点 value 里存着新的对应节点
        for(Node cur = head; cur != null; cur = cur.next){
            hashMap.put(cur, new Node(cur.val,null,null));
        }
        //再次遍历链表，改变新的链表对应的节点位置
        for(Node cur = head; cur != null; cur = cur.next){
            //通过 .get()获取到新链表对应节点，再 .next() 指向下一节点的位置
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
        }
        return hashMap.get(head);
    }
    // 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
    // S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头
    // 中有多少是宝石

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < J.length(); i++){
            hashSet.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(hashSet.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }

}
