package jzOffer;

import util.TreeNode;

import java.util.Map;

/**
 * Created by 杜文丽 on 10/22/2020 10:55 PM
 **/
public class BalancedBinaryTree56 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(right-left)>1){
            return false;
        }
        return isBalanced(root.right)&&isBalanced(root.left);
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left)+1;
        int right = dfs(root.right)+1;
        return Math.max(left,right);
    }
}
