import java.util.*;
class Solution{
    public static void main(String[] args) {
        int i = 1<<31;
        int j = ~(1<<31);
        System.out.println(i);
        System.out.println(j);
        for (int k = i; k < j ; k++) {

        }
        for (int k = 1<<31; k <~(1<<31) ; k++) {

        }
    }
}
class People implements Comparable<People>{
    public int num;
    public int value;
    public People(int num,int value){
        this.num = num;
        this.value = value;
    }

    @Override
    public int compareTo(People p){
        if(this.value == p.value){
            return 0;
        }else if(this.value>p.value){
            return 1;
        }else{
            return -1;
        }
    }

}
public class Test {
}
