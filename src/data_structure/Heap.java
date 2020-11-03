package data_structure;

import java.util.ArrayList;

/**
 * Created by 杜文丽 on 11/3/2020 3:47 PM
 * <p>
 * 当前结点i 父节点：(i-1)/2 左子树：i*2+1 右子数：i*2+2
 * 数组实现大顶堆：
 * 当插入一个元素时，先将这个元素插入到队列尾，
 * 然后将这个新插入的元素和它的父节点进行优先权
 * 的比较，如果比父节点的优先权要大，则和父节点
 * 互换位置，然后再和新的父节比较，直到比新的父
 * 节点优先权小为止
 **/
public class Heap {
    ArrayList<Integer> list = new ArrayList();

    public Heap() {
    }

    public Heap(Integer[] arrs) {
        for (Integer i : arrs
        ) {
            add(i);
        }
    }

    public void add(int val) {
        list.add(val);
        int currIndex = list.size() - 1;
        while (currIndex >= 0) {
            if (list.get((currIndex - 1) / 2) < list.get(currIndex)) {
                change((currIndex-1) / 2,currIndex);
            } else {
                break;
            }
            currIndex = (currIndex - 1) / 2;
        }
    }
    public void change(int index1,int index2){
        if (index1 >= list.size() || index2 >= list.size()){
            return;
        }
        Integer tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }

    public Integer remove() {
        //remove根节点 不断比较孩子结点 大的往上移
        if (list.size() < 1) {
            return null;
        }
        Integer root = list.get(0);
        change(list.size()-1,0);//将最后一个结点放到根节点
        int currIndex = 0;
        int leftChild = currIndex * 2 + 1;
        int rightChild = currIndex * 2 + 2;
        while (currIndex < list.size()) {
            if (leftChild >= list.size()){
                break;
            }
            int maxIndex = leftChild;
            if (rightChild < list.size()){
                if (list.get(rightChild) > list.get(leftChild)){
                    maxIndex = rightChild;
                }
            }
            if (list.get(maxIndex) > list.get(currIndex)){
                change(maxIndex,currIndex);
                currIndex = maxIndex;
            }else {
                break;
            }

        }
        return root;
    }

    public int getSize() {
        return list.size();
    }
}
