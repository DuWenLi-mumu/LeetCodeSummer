package schoolRecruitWrittenTest.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/21/2019 6:55 PM
 **/
public class Problem1 {
    public static void main(String[] args) {
        //8 1 2 3 4 5 6 A
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        List<String> nums= Arrays.asList(str.split(" "));
        ArrayList<String> myres=new ArrayList<>();
        for (int i = 1; i <nums.size() ; i++) {
            if (nums.get(i).equals("A")){
                myres.add("12");
                myres.add("34");
            }else if (nums.get(i).equals("B")){
                myres.add("AB");
                myres.add("CD");
            }else {
                myres.add(nums.get(i));
            }
        }
        System.out.print(Integer.toHexString(myres.size()+1).toUpperCase()+" ");
        for (int i = 0; i <myres.size() ; i++) {
            System.out.print(myres.get(i)+" ");
        }
        System.out.println();
    }

}





