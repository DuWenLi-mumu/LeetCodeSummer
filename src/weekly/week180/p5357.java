package weekly.week180;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 3/15/2020 10:50 AM
 **/
public class p5357 {

}
class CustomStack {
    int maxSize=0;
    List<Integer> arr=new ArrayList<>();
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
    }

    public void push(int x) {
        if (arr.size()>=maxSize){
            return;
        }else {
            arr.add(x);
        }
    }

    public int pop() {
        if (arr.isEmpty()){
            return -1;
        }
        int num=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return num;
    }

    public void increment(int k, int val) {
        if (arr.size()<=k){
            for (int i = 0; i <arr.size() ; i++) {
                arr.set(i,arr.get(i)+val);
            }
        }else {
            for (int i = 0; i <k; i++) {
                arr.set(i,arr.get(i)+val);
            }
        }
    }
}

