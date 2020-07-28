package dfs;

import util.TreeNode;

/**
 * Created by 杜文丽 on 7/28/2020 9:00 PM
 **/
public class PathSum112 {
    public static void main(String[] args) {
        PathSum112 pathSum112=new PathSum112();
        boolean res=pathSum112.hasPathSum(null,0);
    }
    int sum=0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        this.sum=sum;
        return dfs(root,0);
    }
    public boolean dfs(TreeNode treeNode,int curr){
        if (treeNode==null){
            if (curr!=sum){
                return false;
            }else {
                return true;
            }
        }
        curr+=treeNode.val;
        if (treeNode.left==null&&treeNode.right!=null||treeNode.right==null&&treeNode.left!=null){
            if (treeNode.left!=null){
                return dfs(treeNode.left,curr);
            }else {
                return dfs(treeNode.right,curr);
            }
        }else {
            return dfs(treeNode.left,curr)||dfs(treeNode.right,curr);
        }
    }
}
