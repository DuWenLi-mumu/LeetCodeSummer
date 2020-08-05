package kickstart.roundA2020;

import java.util.*;

/**
 * Created by 杜文丽 on 8/5/2020 2:22 PM
 **/
public class Allocation {
    //    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        int cases=in.nextInt();
//        for (int i = 0; i <cases ; i++) {
//            int N=in.nextInt();
//            int B=in.nextInt();
//            int currSum=0;
//            int size=0;
//            PriorityQueue<Integer> list=new PriorityQueue<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    if (o1>o2){
//                        return -1;
//                    }else if (o1<o2){
//                        return 1;
//                    }
//                    return 0;
//                }
//            });
//            for (int j = 0; j <N ; j++) {
//                int next=in.nextInt();
//                currSum+=next;
//                if (currSum<=B){
//                    size++;
//                    list.add(next);
//                }else {
//                    if (list.size()>0){
//                        if (list.peek()>next){
//                            currSum-=list.peek();
//                            list.add(next);
//                        }else {
//                            currSum-=next;
//                        }
//                    }else {
//                        currSum=0;
//                    }
//                }
//            }
//            System.out.println("Case #"+(i+1)+": "+size);
//
//        }
//        in.close();
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = in.nextInt();
            int B = in.nextInt();
            int currSum = 0;
            int size = 0;
            int[] houses = new int[N];
            for (int j = 0; j < N; j++) {
                houses[j] = in.nextInt();
            }
            Arrays.sort(houses);
            for (int j = 0; j <N ; j++) {
                currSum+=houses[j];
                if (currSum<=B){
                    size++;
                }else {
                    break;
                }
            }
            System.out.println("Case #"+(i+1)+": "+size);
        }
        in.close();
    }
}
