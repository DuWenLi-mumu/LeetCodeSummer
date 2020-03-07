package everyday_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 3/7/2020 6:10 PM
 **/
public class MaximumValueOfQueue59 {
    List<Integer> list;
    int max=-1;

    public MaximumValueOfQueue59() {
        list = new ArrayList<>();
    }

    public int max_value() {
        if (list.size()==0){
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        list.add(value);
        if (value>max){
            max=value;
        }
    }

    public int pop_front() {
        if (list.size()==0){
            return -1;
        }
        int front=list.get(0);
        list.remove(0);
        if (front==max){

            if (list.size()==0){
                max=-1;
            }else {
                max=list.get(0);
                for (int i = 1; i <list.size() ; i++) {
                    if (max<list.get(i))
                        max=list.get(i);
                }
            }

        }
        return front;
    }
}
