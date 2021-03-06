package tree;

import util.TreeNode;

/**
 * Created by 杜文丽 on 2020/1/13 14:49
 **/
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return depth(root,0);
    }
    boolean leaf(TreeNode root){
        if (root!=null&&root.left==null&&root.right==null){
            return true;
        }
        return false;
    }
    public int depth(TreeNode root,int curr){
        if (root==null){
            return 0;
        }
        if (leaf(root)){
            return curr;
        }
        return Math.max(depth(root.left,curr+1),depth(root.right,curr+1));
    }
}
