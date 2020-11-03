package jzOffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by 杜文丽 on 11/3/2020 9:20 PM
 **/
public class TheMaximumValueOfTheSlidingWindow59 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[0];
        if(nums.length < 1){
            return res;
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k ; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k ; i < nums.length; i++) {
            res[index++] = priorityQueue.peek();
            priorityQueue.remove(nums[i-k]);
            priorityQueue.add(nums[i]);
        }
        res[index] = priorityQueue.peek();
        return res;

    }

    public static void main(String[] args) {
//        String rawString = "Entwickeln Sie mit Vergnügen";
//        ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString);
//        String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
//        System.out.println(rawString.equals(utf8EncodedString));
//        /////////////////////////////////////////////////////////////////////
//        String rawString2 = "Entwickeln Sie mit Vergnügen";
//        byte[] bytes = rawString2.getBytes(StandardCharsets.UTF_8);
//        String utf8EncodedString2 = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println(rawString2.equals(utf8EncodedString2));
//        ///////////////////////////////////////////////////////////////////////
//        String englishString = "Entwickeln Sie mit Vergnügen";
//        byte[] englishBytes = englishString.getBytes();
//        String asciiEncondedEnglishString = new String(englishBytes, StandardCharsets.US_ASCII);
//        System.out.println((asciiEncondedEnglishString.equals(englishString)));
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);
    }
}
