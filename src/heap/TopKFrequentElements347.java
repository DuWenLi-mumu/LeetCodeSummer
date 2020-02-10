package heap;

import java.util.*;

/**
 * Created by 杜文丽 on 2/10/2020 9:21 PM
 **/
public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        List<Integer> res=new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i <k ; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
