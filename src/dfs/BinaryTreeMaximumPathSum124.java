package dfs;

import util.TreeNode;

/**
 * Created by 杜文丽 on 7/29/2020 9:47 PM
 **/
public class BinaryTreeMaximumPathSum124 {
    int max=-2222111;
    public int maxPathSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=Math.max(0,dfs(root.left));//找到左边单边的最大值
        int right=Math.max(0,dfs(root.right));//找到右边单边的最小值
        max=Math.max(max,root.val+left+right);//选与不选
        return Math.max(0,Math.max(root.val+left,root.val+right));//返回单边
    }
}
