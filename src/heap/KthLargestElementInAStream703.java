package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by 杜文丽 on 2/9/2020 10:55 PM
 **/
public class KthLargestElementInAStream703 {
    ArrayList<Integer> arrs=new ArrayList<>();
    int k=0;
    public void KthLargest(int k, int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            arrs.add(nums[i]);
        }
        this.k=k;
    }

    public int add(int val) {
        arrs.add(val);
        Collections.sort(arrs);
        return arrs.get(arrs.size()-k);
    }
}
