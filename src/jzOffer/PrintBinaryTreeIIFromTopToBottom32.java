package jzOffer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 1/26/2021 8:42 PM
 **/
public class PrintBinaryTreeIIFromTopToBottom32 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return res;
        }
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        bfs(curr);
        return res;
    }
    public void bfs(List<TreeNode> curr){
        List<TreeNode> next = new ArrayList<>();
        if (curr.size() > 0){
            List<Integer> currRes = new ArrayList<>();
            for (TreeNode node:curr
            ) {
                currRes.add(node.val);
                if (node.left != null){
                    next.add(node.left);
                }
                if (node.right != null){
                    next.add(node.right);
                }
            }
            res.add(currRes);
            bfs(next);
        }
    }
}
