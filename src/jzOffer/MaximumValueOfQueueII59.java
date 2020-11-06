package jzOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by 杜文丽 on 11/3/2020 11:02 PM
 **/
public class MaximumValueOfQueueII59 {
    List<Integer> list;
    int max = -1;

    public void mergeSort(int[] nums) {
        //i为每一段的长度
        for (int i = 1; i < nums.length; i *= 2) {
            int index = 0;
            while (2 * i + index <= nums.length) {
                index += 2 * i;
                merge(nums, index - 2 * i, index, index - i);
            }
            if (index + i < nums.length) {
                merge(nums, index, nums.length, index + i);
            }
        }

    }

    public void merge(int[] nums, int start, int end, int mid) {
        int[] copy = new int[nums.length];
        int index1 = start;
        int index2 = mid;
        int index = start;
        while (index1 < mid && index2 <= end) {
            if (nums[index1] < nums[index2]) {
                copy[index++] = nums[index1++];
            } else {
                copy[index++] = nums[index2++];
            }
        }
        while (index1 < mid) {
            copy[index++] = nums[index1++];
        }
        while (index2 <= end) {
            copy[index++] = nums[index2++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = copy[i];
        }
    }


    public MaximumValueOfQueueII59() {
        list = new ArrayList<>();
    }

    public int max_value() {
        if (list.size() < 1) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        list.add(value);
        max = Math.max(value, max);
    }

    public int pop_front() {
        if (list.size() < 1) {
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
        int n = 5;
        //一位加法
        int a1 = (n >> 1) & (0x55555555);
        int a2 = (n & 0x55555555) << 1;
        int tmp = ((a1 & a2) << 1) | (a1 ^ a2);

        //二位加法
        a1 = ((tmp >> 2) & 0x33333333);
        a2 = (tmp & 0x33333333) << 2;
        tmp = ((a1 & a2) << 1) | (a1 ^ a2);
        //四位加法
        a1 = tmp & 0x0000000f;
        a2 = tmp & 0x000000f0 >> 4;
        int sum1 = a1 + a2;
        tmp = ((a1 & a2) << 1) | (a1 ^ a2);

        a1 = tmp & 0x000000ff;
        a2 = tmp & 0x000ff00 >> 8;
        int sum2 = a1 + a2;
        a1 = tmp & 0x00ff0000 >> 16;
        a2 = tmp & 0xff000000 >> 24;
        tmp = sum2 + a1 + a2;

        a1 = tmp & 0x0000ffff;
        a2 = tmp & 0xffff0000 >> 16;
        tmp = a1 + a2;

    }

}
