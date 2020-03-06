package everyday_problem;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 3/6/2020 6:10 PM
 **/
public class TheSequenceOfConsecutivePositiveNumbersOfSum57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        if (target<=2){
            return new int[0][0];
        }
        for (int i = 1; i <target ; i++) {
            int[] curr=sub(i,target);
            if (curr==null){
                continue;
            }else {
                res.add(curr);
            }

        }
        int[][] list = new int[res.size()][];
        for (int i = 0; i < list.length; i++) {
            list[i] = res.get(i);
        }
        return list;
    }
    public int[] sub(int begin, int target){
        int curr=0;
        List<Integer> res=new ArrayList<>();
        for (int i = begin; i <target ; i++) {
            if (curr==target){
                int[] arr=new int[res.size()];
                for (int j = 0; j < res.size(); j++) {
                    arr[j]=res.get(j);
                }
                return arr;
            }
            if (curr>target){
                return null;
            }
            curr+=i;
            res.add(i);
        }
        return null;
    }
}
