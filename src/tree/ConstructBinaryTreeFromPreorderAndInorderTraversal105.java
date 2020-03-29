package tree;

import util.TreeNode;

/**
 * Created by 杜文丽 on 2020/1/13 15:01
 * 思路：
 * 预处理：
 * 从前序遍历中取出第一个数==>根节点
 * 根据根节点值从中序遍历中找到index 将中序遍历拆分成左中序和右中序
 * 根据左中序和右中序的数量把前序拆成左前序和右前序
 * <p>
 * 正式处理：
 * 找到左前序第一个数 是左子树的根节点 再进行上述拆分
 * 找到右前序第一个数 是右子树的根节点 再进行上述拆分
 *
 *
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        //划分边界
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = find(root.val, inorder, inLeft, inRight);
        int inorderLeft0 = inLeft;
        int inorderLeft1 = rootIndex - 1;
        int inorderRight0 = rootIndex + 1;
        int inorderRight1 = inRight;

        int preorderLeft0 = preLeft + 1;
        int preorderLeft1 = inorderLeft1 - inorderLeft0 + preorderLeft0;
        int preorderRight0 = preorderLeft1+1;
        int preorderRight1 = preRight;

        root.left=build(preorder,inorder,preorderLeft0,preorderLeft1,inorderLeft0,inorderLeft1);
        root.right=build(preorder,inorder,preorderRight0,preorderRight1,inorderRight0,inorderRight1);
        return root;
    }

    public int find(int val, int[] inorder, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == val) {
                return i;
            }

        }
        return 0;
    }
}
