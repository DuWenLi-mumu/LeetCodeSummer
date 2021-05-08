package schoolRecruitWrittenTest.byteDanceExam.data;
import java.util.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,5,3,2,4,2,3};
        int target = 10;

    }
    public static int[] find(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            int[] res = subFind(nums,target - nums[i],i);
            if (res != null){
                int[] result = new int[3];
                result[0] = nums[i];
                result[1] = res[0];
                result[2] = res[1];
                return result;
            }
        }
        return null;
    }
    public static int[] subFind(int[] nums,int target,int index){
        Map<Integer,Integer> list = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == index){
                continue;
            }
            list.put(nums[i],nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == index){
                continue;
            }
            int a = nums[i];
            int b = target - nums[i];
            if (list.get(b) != null){
                int[] res = new int[2];
                res[0] = a;
                res[1] = b;
                return res;
            }
        }
        return null;
    }
}
