package dfs;

import util.TreeNode;

/**
 * Created by 杜文丽 on 8/2/2020 9:16 PM
 **/
public class SumRootToLeafNumbers129 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode treeNode,int curr){
        if (treeNode==null){
            return;
        }
        curr=curr*10+treeNode.val;
        if (treeNode.right==null&&treeNode.left==null){
            sum+=curr;
            return;
        }
        dfs(treeNode.left,curr);
        dfs(treeNode.right,curr);
    }
}
