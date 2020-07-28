package everyday_problem;

import util.TreeNode;


/**
 * Created by 杜文丽 on 7/28/2020 8:34 PM
 **/
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }
        return Math.max(dfs(treeNode.left)+1,dfs(treeNode.right)+1);
    }
}
