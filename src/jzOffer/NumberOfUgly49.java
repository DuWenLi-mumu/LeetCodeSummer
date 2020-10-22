package jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 10/22/2020 3:13 PM
 **/
public class NumberOfUgly49 {
    public int nthUglyNumber(int n) {
        int p_2 = 0;
        int p_3 = 0;
        int p_5 = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while (list.size() < n) {
            int n2 = list.get(p_2) * 2;
            int n3 = list.get(p_3) * 3;
            int n5 = list.get(p_5) * 5;
            if (n2 < n3 && n2 < n5) {
                list.add(n2);
                p_2++;
            } else if (n3 < n5 && n3 < n2) {
                list.add(n3);
                p_3++;
            } else if (n5 < n3 && n5 < n2){
                list.add(n5);
                p_5++;
            } else if (n2 == n3 && n2 < n5){
                list.add(n2);
                p_2 ++;
                p_3 ++;
            } else if (n2 == n5 && n2 < n3){
                list.add(n2);
                p_2 ++;
                p_5 ++;
            } else if (n3 == n5 && n3 < n2){
                list.add(n3);
                p_3 ++;
                p_5 ++;
            } else if (n2 == n3 && n2 == n5){
                list.add(n2);
                p_2 ++;
                p_3 ++;
                p_5 ++;
            }
        }
        return list.get(list.size()-1);

    }
}
