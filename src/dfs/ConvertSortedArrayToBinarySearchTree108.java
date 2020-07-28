package dfs;

import util.TreeNode;

/**
 * Created by 杜文丽 on 7/28/2020 8:38 PM
 **/
public class ConvertSortedArrayToBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }
    public TreeNode dfs(int[] nums,int left,int right){
        if (left==right){
            return new TreeNode(nums[left]);
        }else if (left>right){
            return null;
        }
        int mid=(left+right)/2;
        if ((right-left+1)%2==0){
            mid+=1;
        }

        TreeNode newRoot=new TreeNode(nums[mid]);
        newRoot.left=dfs(nums,left,mid-1);
        newRoot.right=dfs(nums,mid+1,right);
        return newRoot;
    }
}
