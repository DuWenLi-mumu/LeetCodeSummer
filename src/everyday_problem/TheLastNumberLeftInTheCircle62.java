package everyday_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 3/30/2020 10:13 PM
 **/
public class TheLastNumberLeftInTheCircle62 {
    public int lastRemaining(int n, int m) {
        List<Integer> nums=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            nums.add(i);
        }
        int curr=0;
        while (nums.size()>1){
            curr=(curr+m-1)%nums.size();
            nums.remove(curr);
        }
        return nums.get(0);
    }
}
