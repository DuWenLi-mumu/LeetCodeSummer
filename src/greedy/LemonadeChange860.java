package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 2/12/2020 10:12 PM
 **/
public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills) {
        int[] remainBills={0,0,0};//0->5 1->10 2->20
        for (int i = 0; i <bills.length ; i++) {
            if (bills[i]==5){
                remainBills[0]++;
            }else if (bills[i]==10){
                if (remainBills[0]!=0){
                    remainBills[0]--;
                    remainBills[1]++;
                }else {
                    return false;
                }
            }else {
                if (remainBills[1]!=0&&remainBills[0]!=0){
                    remainBills[1]--;
                    remainBills[0]--;
                    remainBills[2]++;
                }else if (remainBills[0]>=3){
                    remainBills[0]-=3;
                    remainBills[2]++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
