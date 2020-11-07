package dfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 8/14/2019 3:27 PM
 **/
public class PathSumII113 {
    public void sub(int currSum, int target, List<List<Integer>> res, List<Integer> currRes, TreeNode root){
        if (root==null){
            return;
        }
        currSum+=root.val;
        currRes.add(root.val);
        if (currSum==target&&root.right==null&&root.left==null){
            res.add(currRes);
            return;
        }
        List<Integer> curr1=new ArrayList<>(currRes);
        List<Integer> curr2=new ArrayList<>(currRes);
        sub(currSum,target,res,curr1,root.left);
        sub(currSum,target,res,curr2,root.right);

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        sub(0,sum,res,new ArrayList<>(),root);
        return res;
    }
}
