package advancedPractice;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdvancedPractice {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }
        Help(root, 0);
        return result;
    }
    public  void Help(TreeNode root, int level){
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left != null){
            Help(root.left, level + 1);
        }
        if(root.right != null ){
            Help(root.right, level + 1);
        }
    }

    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    private TreeNode loc = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        findNode(root, p ,q);
        return loc;
    }
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right , p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid >= 2 ) {
            loc = root;
        }
        return left + right + mid > 0;
    }

    // 用来保存最终的字符串结果
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        Helper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
    private void Helper(TreeNode root){
        if(root == null){
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        Helper(root.left);
        if (root.left == null && root.right != null){
            stringBuilder.append("()");
        }
        Helper(root.right);
        stringBuilder.append(")");
    }
}
