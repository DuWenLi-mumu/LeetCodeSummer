package jzOffer;

import util.TreeNode;

/**
 * Created by 杜文丽 on 11/9/2020 3:12 PM
 **/
public class ReconstructABinaryTree7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,preorder.length - 1,0,inorder.length - 1,preorder,inorder);
    }
    public TreeNode build(int preleft, int preright, int inleft, int inright, int[] pre, int[] in) {
        if (preleft > preright || inleft > inright
                || preleft < 0 || preleft >= pre.length
                || preright < 0 || preright >= pre.length
                || inleft < 0 || inleft >= in.length
                || inright < 0 || inright >= in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preleft]);
        int inleft1 = -1, inleft2 = -1, inright1 = -1, inright2 = -1;
        //从中序遍历中寻找根节点来划分
        for (int i = inleft; i <= inright; i++) {
            if (pre[preleft] == in[i]) {
                inleft1 = inleft;
                inright1 = i - 1;
                inleft2 = i + 1;
                inright2 = inright;
                break;
            }
        }
        int preleft1 = -1, preright1 = -1, preleft2 = -1, preright2 = -1;
        int preLeftLength = inright1 - inleft1 + 1;
        int preRightLength = inright2 - inleft2 + 1;
        preleft1 = preleft + 1;
        preright1 = preleft1 + preLeftLength - 1;
        preleft2 = preright1 + 1;
        preright2 = preleft2 + preRightLength - 1;
        root.left = build(preleft1,preright1,inleft1,inright1,pre,in);
        root.right = build(preleft2, preright2, inleft2, inright2,pre,in);
        return root;
    }
}
