package everyday_problem;

/**
 * Created by 杜文丽 on 3/10/2020 6:38 PM
 **/
public class DiameterOfBinaryTree543 {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        sub(root);
        return res;
    }
    public int sub(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=sub(root.left)+1;
        int right=sub(root.right)+1;
        int curr=Math.max(left,right);
        res=Math.max(res,left+right-2);
        return curr;
    }
}
