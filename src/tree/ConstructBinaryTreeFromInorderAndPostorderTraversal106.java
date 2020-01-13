package tree;

/**
 * Created by 杜文丽 on 2020/1/13 16:48
 * 后序遍历是最后一个为根节点
 * 左右根的顺序来遍历的
 **/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder, int[] postorder,int inLeft,int inRight,int postLeft,int postRight){
        if (inLeft>inRight||postLeft>postRight){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postRight]);
        int rootIndex=find(postorder[postRight],inorder,inLeft,inRight);
        int inorderLeft0=inLeft;
        int inorderLeft1=rootIndex-1;
        int inorderRight0=rootIndex+1;
        int inorderRight1=inRight;

        int postLeft0=postLeft;
        int postLeft1=postLeft+inorderLeft1-inorderLeft0;
        int postRight0=postLeft1+1;
        int postRight1=postRight-1;

        root.left=build(inorder,postorder,inorderLeft0,inorderLeft1,postLeft0,postLeft1);
        root.right=build(inorder,postorder,inorderRight0,inorderRight1,postRight0,postRight1);
        return root;
    }
    public int find(int val,int[] inorder,int inLeft,int inRight){
        for (int i = inLeft; i <=inRight ; i++) {
            if (inorder[i]==val){
                return i;
            }
        }
        return inLeft;
    }
}
