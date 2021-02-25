package jzOffer;

import util.TreeNode;

public class BinarySearchTreesAndBidirectionalLinkedLists36 {
    TreeNode head = new TreeNode(0);
    TreeNode tail = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null){
            return root;
        }
        tail = head;
        dfs(root);
        tail.right = head.right;
        head.right.left = tail;
        return head.right;
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        tail.right = root;
        root.left = tail;
        tail = root;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);

        a4.left = a2;
        a4.right = a5;
        a2.left = a1;
        a2.right = a3;

        BinarySearchTreesAndBidirectionalLinkedLists36 test = new BinarySearchTreesAndBidirectionalLinkedLists36();
        test.treeToDoublyList(a4);

    }
}
