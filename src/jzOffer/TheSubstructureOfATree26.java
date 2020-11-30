package jzOffer;

import sun.reflect.generics.tree.Tree;
import util.TreeNode;

/**
 * Created by 杜文丽 on 11/26/2020 2:12 PM
 **/
public class TheSubstructureOfATree26 {
    public boolean isSubStructure(TreeNode root, TreeNode sub) {
        if (sub == null || root == null){
            return false;
        }
        return sub(root,sub);
    }
    public boolean sub(TreeNode root, TreeNode sub){
        if (root == null){
            return false;
        }
        if (help(sub,root)){
            return true;
        }
        return sub(root.left,sub) || sub(root.right,sub);
    }
    public boolean help(TreeNode curr,TreeNode root){
        if (curr == null){
            return true;
        }
        if (curr != null && root != null && curr.val == root.val){

            if (help(curr.left,root.left) && help(curr.right,root.right)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(-4);
        TreeNode r5 = new TreeNode(-3);
        TreeNode r6 = new TreeNode(1);
        TreeNode r7 = new TreeNode(-4);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r6.left = r7;

        TheSubstructureOfATree26 test = new TheSubstructureOfATree26();
        test.isSubStructure(r1,r6);
    }
}
