package jzOffer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 杜文丽 on 1/28/2021 10:08 PM
 **/
public class PrintBinaryTreeIIIFromTopToBottom32 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return res;
        }
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        bfs(curr);
        for (int i = 1; i <res.size() ; i+=2) {
            Collections.reverse(res.get(i));
        }
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

