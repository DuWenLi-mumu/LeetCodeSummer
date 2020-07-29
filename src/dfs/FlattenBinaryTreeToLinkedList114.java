package dfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 7/29/2020 9:22 PM
 **/
public class FlattenBinaryTreeToLinkedList114 {
    List<TreeNode> list=new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode curr=root;
        for (int i = 1; i <list.size() ; i++) {
            curr.left=null;
            curr.right=list.get(i);
            curr=list.get(i);
        }
    }
    public void dfs(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        list.add(treeNode);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
