package data_structure;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by 杜文丽 on 10/15/2020 4:28 PM
 **/
public class PostOrderImp {
    Stack<TreeNode> stack = new Stack<>();

    public void print(TreeNode node) {
        System.out.print(node.val + " ");
    }

    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            stack.add(node.right);
        }
        if (node.left != null) {
            stack.add(node.left);
        }
    }

    public void postOrderNonRecursion(TreeNode root) {
        stack.add(root);
        add(root);
        TreeNode curr = stack.peek();
        TreeNode pre = curr;
        while (!stack.empty()) {
            curr = stack.peek();
            if (pre == curr.right) {
                print(curr);
                pre = curr;
                stack.pop();
                continue;
            }
            if (pre == curr.left) {
                add(curr.right);
            } else {
                while (curr.left != null || curr.right != null) {
                    add(curr);
                    curr = stack.peek();
                }
            }

            curr = stack.pop();
            print(curr);
            pre = curr;
        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n8.right = n9;
        PostOrderImp test = new PostOrderImp();
        test.postOrderNonRecursion(n1);
    }
}
