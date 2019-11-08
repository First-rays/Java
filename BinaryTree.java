package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    // 子问题思路-求第 k 层结点个数
    public static int getKLevelSize(Node root, int k){
        if(root == null || k == 0){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left, k - 1) +
                getKLevelSize(root.right, k - 1);
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public static Node find(Node root, char val){
        if(root == null){
            return null;
        }
        if(root.val ==val){
            return root;
        }
        //左子树没找到返回初始节点
        Node ret = find(root.left, val);
        if(ret == null){
            return ret;
        }
        return find(root.right, val);
    }

    //层序遍历
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        //将根节点入队
        queue.offer(root);
        while(!queue.isEmpty()){
            //首元素出队，循环访问队首元素
            Node ret = queue.poll();
            System.out.print(ret.val + " ");
            //如果 ret 的左右节点不为空，则入队
            if(ret.left != null){
                queue.offer(ret.left);
            }
            if(ret.right != null){
                queue.offer(ret.right);
            }
        }
    }

    //判断一个树是不是完全二叉树
    public static boolean isCompleteTree(Node root){
        if(root == null){
            return true;
        }
        //通过层序遍历分为两个部分
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Boolean hasNoChild = false;
        while(!queue.isEmpty()){
            Node ret = queue.poll();
            if(!hasNoChild){
                //第一阶段的几种情况：
                if(ret.right != null && ret.right != null){
                    queue.offer(ret.left);
                    queue.offer(ret.right);
                } else if(ret.left == null && ret.right != null){
                    return false;
                } else if(ret.left != null && ret.right == null){
                    queue.offer(ret.left);
                    hasNoChild = true;
                } else{
                    hasNoChild = true;
                }
            } else{
                //第二阶段，左右子树都为空
                if(ret.left != null || ret.right != null){
                    return false;
                }
            }

        } //end while()
        return true;
    }


    //主函数
    public static void main(String[] args) {
        root = build();
//        preOrderTraversal(root);
//        System.out.println();
//        inOrderTraversal(root);
//        System.out.println();
//        postOrderTraversal(root);
//        System.out.println();
//        getSize1(root);
//        System.out.println(size);
//        System.out.println(getSize2(root));
//        getLeafSize1(root);
//        System.out.println(leafSize);
//        System.out.println(getLeafSize2(root));
//        System.out.println(getKLevelSize(root,1));
//        System.out.println(getKLevelSize(root,2));
//        System.out.println(getKLevelSize(root,3));
//        levelOrderTraversal(root);
        System.out.println(isCompleteTree(root));
    }
}
