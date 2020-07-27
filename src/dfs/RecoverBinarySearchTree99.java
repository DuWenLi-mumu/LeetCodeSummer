package dfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 7/27/2020 7:30 PM
 **/
public class RecoverBinarySearchTree99 {
    private TreeNode x=null;
    private TreeNode y=null;
    private List<TreeNode> list=new ArrayList<>();
    public void recoverTree(TreeNode root) {
        dfs(root);
        for (int i = 0; i <list.size()-1 ; i++) {
            if (list.get(i).val>list.get(i+1).val){
                if (x==null){
                    x=list.get(i);
                }
                y=list.get(i+1);

            }
        }
        //交换
        if (x!=null&&y!=null){
            int tmp=y.val;
            y.val=x.val;
            x.val=tmp;
        }
    }
    public void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }
}
