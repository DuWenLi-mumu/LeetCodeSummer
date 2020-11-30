package jzOffer;

import util.TreeNode;

/**
 * Created by 杜文丽 on 11/30/2020 9:34 PM
 **/
public class TheMirrorImageOfABinaryTree27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }
}
