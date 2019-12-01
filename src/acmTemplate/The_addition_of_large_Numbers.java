package acmTemplate;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/20/2019 4:02 PM
 **/
public class The_addition_of_large_Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
    }

    public String myAdd(String s1,String s2){
        String big=s1;
        String small=s2;
        if (s1.length()<s2.length()){
            big=s2;
            small=s1;
        }
        return "";
    }
}
