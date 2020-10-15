package data_structure;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by 杜文丽 on 10/15/2020 3:22 PM
 * 出栈的时候打印
 **/
public class InOrderImp {
    Stack<TreeNode> stack = new Stack<>();
    public void inOrderNonRecursion(TreeNode root){
        stack.add(root);
        TreeNode node=root;
        node=add_left(node);
        while (!stack.empty()){
            TreeNode curr=stack.pop();
            print(curr);
            if (curr.right!=null){
                stack.add(curr.right);
                node=add_left(curr.right);
            }
        }

    }
    public void print(TreeNode node){
        System.out.print(node.val+" ");
    }
    public TreeNode add_left(TreeNode node){
        while (node.left!=null){
            stack.add(node.left);
            node=node.left;
        }
        return node;
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

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        n5.left=n8;
        n8.right=n9;
        InOrderImp test=new InOrderImp();
        test.inOrderNonRecursion(n1);
    }
}
