package tree;

class Node{
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    public static Node  root = null;

    //构造一棵树
    public static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    //先序遍历
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");

    }


    //遍历思路求节点个数
    public static int size = 0;
    public static void getSize1(Node root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);

    }
    //子问题思路求节点个数
    public static int getSize2(Node root){
        if(root == null){
            return 0;
        }
        return 1 + getSize2(root.left) + getSize2(root.right);
    }

    // 遍历思路-求叶子结点个数
    private static int leafSize = 0;
    public static void getLeafSize1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    public static int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
             return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }


    //主函数
    public static void main(String[] args) {
        root = build();
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        getSize1(root);
        System.out.println(size);
        System.out.println(getSize2(root));
        getLeafSize1(root);
        System.out.println(leafSize);
        System.out.println(getLeafSize2(root));

    }
}
