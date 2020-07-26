package recursion;

import util.TreeNode;

/**
 * Created by 杜文丽 on 2020/2/5 13:03
 **/
public class RangeSumOfBST938 {
    int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root==null){
            return sum;
        }
        if (root.val>=L&&root.val<=R){
            sum+=root.val;
        }
        rangeSumBST(root.left,L,R);
        rangeSumBST(root.right,L,R);
        return sum;
    }
}
