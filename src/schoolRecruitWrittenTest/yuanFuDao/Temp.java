package schoolRecruitWrittenTest.yuanFuDao;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/24/2019 4:41 PM
 **/
public class Temp {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        HashMap<String,Integer> hashMap=new HashMap<>();
        int num=in.nextInt();
        int rep=in.nextInt();
        String[] nums=new String[num];
        for (int i = 0; i <num ; i++) {
            nums[i]=in.next();
            if (hashMap.containsKey(nums[i])){
                int v=hashMap.get(nums[i]);
                hashMap.put(nums[i],v+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }
        for (int i = 0; i <num ; i++) {
            if (hashMap.get(nums[i])>rep){

            }else{
                System.out.print(nums[i]+" ");
            }
        }
        System.out.println();
    }
}
