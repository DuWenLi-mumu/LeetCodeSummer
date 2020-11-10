package schoolRecruitWrittenTest.byteDanceExam.pddExam;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 8/11/2019 2:48 PM
 **/
public class Problem1 {
    public static double  variance(double num1,double num2,double num3){
        double avg=(num1+num2+num3)/3;
        return (Math.pow(num1-avg,2)+Math.pow(num2-avg,2)+ Math.pow(num3-avg,2))/3;
    }
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int num = sc.nextInt();
          double[] n=new double[num];
        for (int i = 0; i <num ; i++) {
            n[i]=sc.nextDouble();
        }

        double min=1000000;
        for (int i = 0; i <num ; i++) {
            for (int j = i+1; j <num ; j++) {
                for (int k = j+1; k <num ; k++) {
                    double res=variance(n[i],n[j],n[k]);
                    if (min>res){
                        min=res;
                    }
                }
            }
        }

        System.out.println(String.format("%.2f",min));

    }
}
