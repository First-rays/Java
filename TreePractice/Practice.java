package TreePractice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class Practice {
    private static Node root = null;
    //层序遍历
    public static void levelTrave(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
             Node node = queue.poll();
            System.out.print(node.val);
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }
    }
    //判断一个树是不是完全二叉树
    public static boolean isCompleteTree(Node root) {
        if(root == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(!flag){
                if(cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if(cur.left == null && cur.right != null){
                    return false;
                } else if(cur.left != null && cur.right ==null){
                    queue.offer(cur.left);
                    flag = true;
                } else{
                    flag = true;
                }
            } else{
                if(root.left != null || root.right == null){
                    return false;
                }
            }
        }
        return true;
    }

    //根据给定值查找节点
    public static Node find(Node root, char val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        Node cur = find(root.left, val);
        if(cur == null){
            return cur;
        }
        return cur = find(root.right, val);
    }
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return result;
        }
        help(root, 0);
        return result;
    }
    private  void help(Node root, int level){
        if(level == result.size()){
            result.add(new LinkedList<>());
        }
        result.get(level).add(root.val);
        if(root.left != null){
            help(root.left, level + 1);
        }
        if(root.right != null){
            help(root.right, level + 1);
        }
    }
    //先序遍历
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.print(cur.val + " ");
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (true){

            while(cur.left != null){
                stack.push(cur.left);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            Node top = stack.pop();
            System.out.print(top.val + " ");
            top = top.right;
        }
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (true){
            while (cur.left != null){
                stack.push(cur.left);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            Node top = stack.peek();
            if(cur.right == null || top.right == prev){
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            } else{
                cur = top.right;
            }
        }
    }
}
