package jzOffer;

import everyday_problem.MaxAreaofIsland695;
import util.TreeNode;

/**
 * Created by 杜文丽 on 10/22/2020 10:53 PM
 **/
public class TheDepthOfTheBinaryTree55 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left,right);
    }
}
