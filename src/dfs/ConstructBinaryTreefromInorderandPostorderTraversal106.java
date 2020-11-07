package dfs;

import util.TreeNode;

/**
 * Created by 杜文丽 on 8/14/2019 1:59 PM
 **/
public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    //in是从前面开始找的，post是从后面开始找的
    public TreeNode sub(int[] inorder, int[]postorder, int postbegin, int postend, int inbegin, int inend){
        if (inbegin>inend||postbegin>postend){
            return null;
        }
        if (inbegin==inend||postbegin==postend){
            return new TreeNode(inorder[inbegin]);
        }
        int inindex=0;//记录根节点
        for (int i = inbegin; i <=inend ; i++) {
            if (inorder[i]==postorder[postend]){
                inindex=i;
                break;
            }
        }
        TreeNode root=new TreeNode(inorder[inindex]);

        root.left=sub(inorder,postorder,postbegin,postbegin+inindex-inbegin-1,inbegin,inindex-1);
        root.right=sub(inorder,postorder,postend-inend+inindex, postend-1,inindex+1,inend);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return sub(inorder,postorder,0,postorder.length-1,0,inorder.length-1);
    }
}
