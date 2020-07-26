package recursion;

import util.TreeNode;

import java.util.ArrayList;

/**
 * Created by 杜文丽 on 2020/2/7 20:47
 **/
public class MinimumDistanceBetweenBSTNodes783 {
    int min=100000000;
    ArrayList<Integer> arrayList=new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root);
        for (int i = 0; i <arrayList.size()-1 ; i++) {
            min=Math.min(arrayList.get(i+1)-arrayList.get(i),min);
        }
        return min;
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        arrayList.add(root.val);
        dfs(root.right);
    }
}
