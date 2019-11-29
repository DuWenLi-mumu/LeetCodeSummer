package schoolRecruitWrittenTest.tx2;

import java.util.Scanner;

/**
 * Created by 杜文丽 on 9/1/2019 7:26 PM
 **/
public class Problem2 {
    static int[][] people=new int[100000][2];
    public static void swop(int i,int j){
        int[][]temp =new  int[1][2];
        temp[0][0]=people[i][0];
        temp[0][1]=people[i][1];
        people[i][0]=people[j][0];
        people[i][1]=people[j][1];
        people[j][0]=temp[0][0];
        people[j][1]=temp[0][1];
    }
    private static void sortmintomax(int lowIndex,int highIndex,int curr) {
        int low=lowIndex;
        int high=highIndex;
        int temp;
        if(lowIndex<highIndex) {
            while (low<=high) {
                temp = people[(lowIndex + highIndex) / 2][curr];
                while ((low<highIndex)&&(people[low][curr]<temp)) {
                    ++low;

                }
                while ((high>lowIndex)&&(people[high][curr]>temp)) {
                    --high;
                }
                if(low<=high) {
                    swop(low, high);
                    ++low;
                    --high;
                }
            }
            if(low<highIndex) {
                sortmintomax(low, highIndex,curr);
            }
            if(high>lowIndex) {
                sortmintomax(lowIndex, high,curr);
            }
        }

    }
    public static void sortmaxtomin(int lowIndex,int highIndex,int curr){
        int low=lowIndex;
        int high=highIndex;
        int temp;
        if(lowIndex<highIndex) {
            while (low<=high) {
                temp = people[(lowIndex + highIndex) / 2][curr];
                while ((low<highIndex)&&(people[low][curr]>=temp)) {
                    ++low;
                }
                while ((high>lowIndex)&&(people[high][curr]<=temp)) {
                    --high;
                }
                if(low<=high) {
                    swop(low, high);
                    ++low;
                    --high;
                }
            }
            if(low<highIndex) {
                sortmaxtomin(low, highIndex,curr);
            }
            if(high>lowIndex) {
                sortmaxtomin(lowIndex, high,curr);
            }
        }
    }

    public static int count(int n){
        int c=0;
        for (int i = 0; i <n ; i++) {
            c+=people[i][0]*(i)+people[i][1]*(n-i-1);
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 0; i <n ; i++) {
            people[i][0]=in.nextInt();
            people[i][1]=in.nextInt();
        }
        sortmaxtomin(0,n-1,0);
        sortmintomax(0,n-1,1);
//        for (int i = 0; i <n ; i++) {
//            System.out.print(people[i][0]+" ");
//        }
//        System.out.println("b:");
//        for (int i = 0; i <n ; i++) {
//            System.out.print(people[i][1]+" ");
//        }
        int min=count(n);
        System.out.println(min);



    }
}

/*


import java.util.Scanner;
public class Main {
    static int[][] people=new int[100000][2];
    public static void change(int i,int j){
        int[][]temp =new  int[1][2];
        temp[0][0]=people[i][0];
        temp[0][1]=people[i][1];
        people[i][0]=people[j][0];
        people[i][1]=people[j][1];
        people[j][0]=temp[0][0];
        people[j][1]=temp[0][1];
    }
    public static void sortmintomax(int curr,int n){
        for (int i = 0; i <n ; i++) {
            int min=people[i][curr];
            int index=i;
            for (int j = i+1; j <n ; j++) {
                if (min>people[j][curr]){
                    min=people[j][curr];
                    index=j;
                }
            }
            if (index==i){
                continue;
            }else {
                change(index,i);
            }
        }
    }
    public static void sortmaxtomin(int curr,int n){
        for (int i = 0; i <n ; i++) {
            int max=people[i][curr];
            int index=i;
            for (int j = i+1; j <n ; j++) {
                if (max<people[j][curr]){
                    max=people[j][curr];
                    index=j;
                }
            }
            if (index==i){
                continue;
            }else {
                change(index,i);
            }
        }
    }
    public static int count(int n){
        int c=0;
        for (int i = 0; i <n ; i++) {
            c+=people[i][0]*(i)+people[i][1]*(n-i-1);
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 0; i <n ; i++) {
            people[i][0]=in.nextInt();
            people[i][1]=in.nextInt();
        }
        sortmaxtomin(0,n);
        sortmintomax(1,n);
        int min=count(n);
        System.out.println(min);



    }
}

 */