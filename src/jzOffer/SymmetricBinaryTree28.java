package jzOffer;

import util.TreeNode;

/**
 * Created by 杜文丽 on 12/5/2020 8:08 PM
 **/
public class SymmetricBinaryTree28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return help(root.left,root.right);
    }
    public boolean help(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }else if (left.val != right.val){
            return false;
        }
        return help(left.left,right.right) && help(left.right,right.left);
    }
}
