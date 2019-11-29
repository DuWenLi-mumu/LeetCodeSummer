package schoolRecruitWrittenTest.tx;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/17/2019 8:03 PM
 **/
public class Problem2 {
    private static int getCount(int[] array,int start,int end){
        if(start>=end)
            return 0;
        int mid=(end+start)>>1;
        int left=getCount(array,start,mid);
        int right=getCount(array,mid+1,end);


        int count=0;
        int i=mid;
        int j=end;
        int[] temp= new int[end-start+1];
        int k=end-start;
        while(i>=start && j>=mid+1){
            if(array[i]>array[j]){
                count+=(j-mid);
                temp[k--]=array[i--];
            }else{
                temp[k--]=array[j--];
            }
        }
        while(i>=start)
            temp[k--]=array[i--];
        while(j>=mid+1)
            temp[k--]=array[j--];
        for(k=0;k<temp.length;k++)
            array[k+start]=temp[k];

        return count+left+right;
    }
//    public static void sub(ArrayList<Integer> nums,int begin,int end){
//        while (begin<end){
//            int tmp=nums.get(begin);
//            nums.set(begin,nums.get(end));
//            nums.set(end,tmp);
//            begin++;
//            end--;
//        }
//    }
//    public static int inverse_number(int[] nums){
//        int res=0;
//        for (int i = 0; i <nums.length ; i++) {
//            for (int j =i+1; j <nums.length; j++) {
//                if (nums[i]>nums[j]){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        n=(int) Math.pow(2,n);
        int[] nums=new int[n];
        int[] numstemp=new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        while ((m--)>0){
            int mi=sc.nextInt();
            mi= (int) Math.pow(2,mi);
            for (int i = 0; i <n ; i+=mi) {
                int begin=i;
                int end=i+mi-1;
                while (begin<end){
                    int tmp=nums[begin];
                    nums[begin]=nums[end];
                    nums[end]=tmp;
                    begin++;
                    end--;
                }
            }
            for (int i = 0; i <nums.length ; i++) {
                numstemp[i]=nums[i];
            }
            System.out.println(getCount(numstemp,0,nums.length-1));
        }
    }
}
