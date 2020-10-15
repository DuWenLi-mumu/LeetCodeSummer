import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int times = 0;
        while(times < num){
            int N = in.nextInt();
            int X = in.nextInt();
            People[] ps=new People[N];
            for(int i = 0;i < N;i++){
                int n=i+1;
                int v=in.nextInt();
                People p=new People(n,(v-1)/X);
                ps[i] = p;
            }
            Arrays.sort(ps);
            System.out.print("Case #"+(times+1)+": ");
            for(int i = 0;i < N;i++){
                System.out.print(ps[i].num+" ");
            }
            System.out.println();
            times++;
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
