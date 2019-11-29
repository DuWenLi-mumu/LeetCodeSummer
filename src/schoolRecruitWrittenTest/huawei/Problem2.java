package schoolRecruitWrittenTest.huawei;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/21/2019 6:56 PM
 **/
public class Problem2 {
    static boolean[] is_prime=new boolean[10000000];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int high,low;
        low=sc.nextInt();
        high=sc.nextInt();
        isPrime(high,low);
        int shi=0;
        int ge=0;
        for (int i = low; i <high ; i++) {
            if (is_prime[i]){
                ge+=gewei(i);
                shi+=shiwei(i);
            }
        }
        System.out.println(Math.min(shi,ge));

    }
    public static int gewei(int num){
        return num%10;
    }
    public static int shiwei(int num){
        return (num/10)%10;
    }
    public static void isPrime(int high,int low) {//包含low
        for (int i = 0; i <=high ; i++) {
            is_prime[i]=true;
        }
        is_prime[0]=false;
        is_prime[1]=false;
        for (int i = 2; i <high ; i++) {
            if (is_prime[i]){
                for (int j = i*2; j <high ; j+=i) {
                    is_prime[j]=false;
                }
            }
        }
    }

}
