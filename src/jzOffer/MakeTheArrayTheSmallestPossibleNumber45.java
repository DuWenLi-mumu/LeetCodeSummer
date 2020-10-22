package jzOffer;

import javax.jnlp.IntegrationService;
import java.util.*;

/**
 * Created by 杜文丽 on 10/19/2020 8:45 PM
 **/
public class MakeTheArrayTheSmallestPossibleNumber45 {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res="";
        for (int i = 0; i < list.size(); i++) {
            res+=list.get(i);
        }
        return res;
    }

    /**
     * int len=1;
     *         for (int i = 0; i < nums.length; i++) {
     *             len=Math.max(String.valueOf(nums[i]).length(),len);
     *         }
     *         List<Num> list = new ArrayList<>();
     *         for (int i = 0; i < nums.length ; i++) {
     *             list.add(new Num(hash(nums[i],len),nums[i]));
     *         }
     *
     *         Collections.sort(list, new Comparator<Num>() {
     *             @Override
     *             public int compare(Num o1, Num o2) {
     *                 return o1.hash-o2.hash;
     *             }
     *         });
     *         String res="";
     *         for (Num num: list
     *              ) {
     *             int val=num.number;
     *             res=res+val;
     *         }
     *         return res;
     */
    class Num{
        public int hash;
        public int number;
        public Num(int hash,int number){
            this.hash = hash;
            this.number = number;
        }
    }
    public int hash(int num,int len){
        int comp = len-String.valueOf(num).length();
        if (comp<=0){
            return num;
        }
        int comtmp=comp;
        int last = num%10;
        int val = last;
        while (comp>1){
            val = val*10 + last;
            comp--;
        }
        return (int) (num*Math.pow(10,comtmp)+val);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        MakeTheArrayTheSmallestPossibleNumber45 test=new MakeTheArrayTheSmallestPossibleNumber45();
        test.minNumber(nums);
    }
}
