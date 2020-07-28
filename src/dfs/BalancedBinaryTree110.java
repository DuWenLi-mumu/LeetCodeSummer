package dfs;

import util.TreeNode;

/**
 * Created by 杜文丽 on 7/28/2020 8:52 PM
 **/
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(dfs(root.left)+1,dfs(root.right)+1);
    }
}
