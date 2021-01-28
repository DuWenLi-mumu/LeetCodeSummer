package jzOffer;

import org.w3c.dom.stylesheets.LinkStyle;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 1/26/2021 8:07 PM
 * 广搜
 **/
public class PrintTheBinaryTreeFromTopToBottom32 {
    List<Integer> res = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        bfs(curr);
        int[] result = new int[res.size()];
        for (int i = 0; i <res.size() ; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    public void bfs(List<TreeNode> curr){
        List<TreeNode> next = new ArrayList<>();
        if (curr.size() > 0){
            for (TreeNode node:curr
                 ) {
                res.add(node.val);
                if (node.left != null){
                    next.add(node.left);
                }
                if (node.right != null){
                    next.add(node.right);
                }
            }
            bfs(next);
        }
    }
}
