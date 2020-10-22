package jzOffer;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 10/22/2020 10:45 PM
 **/
public class TheKTHLargestNodeOfTheBinarySearchTree54 {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return list.get(list.size()-k);
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
