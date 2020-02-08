package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 2/8/2020 10:06 PM
 * 思路：
 * 根节点 既有左孩子 又有右孩子
 * 若n！=0 左子树有孩子，右子树没有孩子；左子树没有孩子，右子树有孩子；左子树右子树都有孩子
 **/
public class AllPossibleFullBinaryTrees894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 0) {
            return res;
        }else if (N==1){
            res.add(new TreeNode(0));
        }

        for (int i = 1; i <=N-1 ; i+=2) {
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-1-i);
            for (TreeNode l:left
                 ) {
                for (TreeNode r:right
                     ) {
                    TreeNode head=new TreeNode(0);
                    head.left=l;
                    head.right=r;
                    res.add(head);
                }
            }
        }
        return res;
    }
}
