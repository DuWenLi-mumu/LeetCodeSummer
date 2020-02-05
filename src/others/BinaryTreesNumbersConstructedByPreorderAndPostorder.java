package others;

/**
 * Created by 杜文丽 on 2020/1/13 17:14
 * 题目描述：
 * 根据前序和后序能够构造出多少种不同的二叉树？
 *
 * 前序：根 左 右
 * 后序：左 右 根
 *
 * 造成多个树的原因是在结点只有一个儿子的时候不知道是左摆还是右摆 数一数有多少个1儿子结点，结果=2^1儿子结点数目
 * 1儿子结点的特征是前序遍历必然存在连续的AB后序遍历必然有BA
 *
 **/
public class BinaryTreesNumbersConstructedByPreorderAndPostorder {
    public int binaryNumbersOfTrees(int[] postOrder,int[] preOrder){
        int num=0;
        for (int i = 0; i <postOrder.length-1 ; i++) {
            if (continuous(postOrder,preOrder,i)){
                num++;
            }
        }

        return (int) Math.pow(2,num);
    }
    public boolean continuous(int[] post,int[] pre,int index){
        if (pre[index]==post[post.length-1-index]&&pre[index+1]==post[post.length-2-index]){
            return true;
        }
        return false;
    }
}
