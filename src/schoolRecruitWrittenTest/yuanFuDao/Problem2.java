package schoolRecruitWrittenTest.yuanFuDao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/24/2019 3:59 PM
 **/
public class Problem2 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int res=0;
        int groups=in.nextInt();
        for (int i = 0; i <groups ; i++) {
            res=0;
            int num=in.nextInt();
            int[] nums=new int[num];
            for (int j = 0; j <num ; j++) {
                nums[j]=in.nextInt();
            }
            if (num<3){
                System.out.println(0);
            }else{
                Arrays.sort(nums);
                int j=num-3;
                while (nums[j]>0){
                    res+=nums[j];
                    nums[j+1]=nums[j+1]-nums[j];
                    nums[j+2]=nums[j+2]-nums[j];
                    nums[j]=0;
                    Arrays.sort(nums);
                }
                System.out.println(res);
            }

        }
    }
}
