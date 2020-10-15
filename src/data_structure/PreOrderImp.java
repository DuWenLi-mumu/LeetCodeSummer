package data_structure;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by 杜文丽 on 10/15/2020 11:04 AM
 * 进栈的时候打印
 **/
public class PreOrderImp {
    Stack<TreeNode> stack=new Stack<>();
    public void preOrderNonRecursion(TreeNode root){
        TreeNode node=root;
        print(node);
        stack.add(node);
        while (!stack.isEmpty()){
            if (node.left==null&&node.right==null){
                //出栈判断右结点
                TreeNode curr=stack.peek();
                TreeNode pre=curr;
                //右结点为空 直接pop
                while (curr.right==null||pre==curr.right){
                    pre=curr;
                    stack.pop();
                    if (!stack.empty()){
                        curr=stack.peek();
                    }else {
                        break;
                    }
                }
                if (stack.empty()){
                    break;
                }
            }
            //第一次遍历
            node=add_left(node);//加左边
            while (node.right!=null){

                node=add_left(node.right);//加右边
            }
            //出栈判断右结点
            TreeNode curr=stack.peek();
            TreeNode pre=curr;
            //右结点为空 直接pop
            while (curr.right==null||pre==curr.right){
                pre=curr;
                stack.pop();
                curr=stack.peek();
            }

            //右结点没有加入过，先加入
            node=curr.right;
            print(node);
            stack.add(node);
        }

    }

    public TreeNode add_left(TreeNode node){
        if (node.left==null&&node.right==null){
            print(node);
            stack.add(node);
            return node;
        }
        while (node.left!=null){
            print(node.left);
            stack.add(node.left);
            node=node.left;
        }
        return node;
    }
    public void print(TreeNode node){
        System.out.print(node.val+" ");
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

        PreOrderImp test=new PreOrderImp();
        test.preOrderNonRecursion(n1);

    }
}
