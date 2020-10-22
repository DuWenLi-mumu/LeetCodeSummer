package jzOffer;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

/**
 * Created by 杜文丽 on 10/22/2020 4:11 PM
 **/
public class AnInvertedPairInAnArray51 {
    public int reversePairs(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        //归并排序 处理逆序数
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return partition(nums,copy,0,nums.length - 1);
    }
    public int partition(int[] data,int[] copy,int start,int end){
        if (start >= end){
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = partition(copy,data,start,start + length);
        int right = partition(copy,data,start + length + 1,end);
        // i j分别都指向 两个数组的最后一位
        int i = start + length;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while (i >= start && j >= start + length + 1){
            if (data[i] > data[j]){
                copy[copyIndex--] = data[i--];
                count += j - start - length;
            }else {
                copy[copyIndex--] = data[j--];
            }
        }
        while (j>=start+length+1){
            copy[copyIndex--] = data[j--];
        }
        while (i >= start){
            copy[copyIndex--] = data[i--];
        }
        return left + right + count;
    }
}

