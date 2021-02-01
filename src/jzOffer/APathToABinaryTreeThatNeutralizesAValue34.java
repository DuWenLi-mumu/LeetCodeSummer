package jzOffer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 杜文丽 on 1/28/2021 10:52 PM
 **/
public class APathToABinaryTreeThatNeutralizesAValue34 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int sum, List<Integer> curr) {
        if (root != null && root.left == null && root.right == null && root.val == sum) {
            curr.add(root.val);
            res.add(curr);
            return;
        }
        if (root == null) {
            return;
        }
        sum -= root.val;
        curr.add(root.val);
        dfs(root.left, sum, curr);
        dfs(root.right, sum, curr);
        curr.remove(curr.size()-1);
    }
}
