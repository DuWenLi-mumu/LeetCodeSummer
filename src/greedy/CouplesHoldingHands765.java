package greedy;

/**
 * Created by 杜文丽 on 2/20/2020 8:06 PM
 **/
public class CouplesHoldingHands765 {
    public static void main(String[] args) {
        int[]arr={0,2,4,6,7,1,3,5};
        minSwapsCouples(arr);
    }
    public static int minSwapsCouples(int[] row) {
        int count=0;
        for (int i = 0; i <row.length-1 ; i+=2) {
            if (legal(row[i],row[i+1])){
                continue;
            }else {
                count++;
                row=exchange(row,i);
            }
        }
        return count;
    }
    public static int[] exchange(int[] row,int index){
        if (index>=row.length){
            return row;
        }
        for (int i = index+1; i <row.length ; i++) {
            if (legal(row[index],row[i])){
                int temp=row[index+1];
                row[index+1]=row[i];
                row[i]=temp;
                return row;
            }
        }
        return row;
    }

    public static boolean legal(int x1,int x2){
        if (Math.abs(x1-x2)<=1){
            if (x1>x2&&x1%2==1||x2>x1&&x2%2==1){
                return true;
            }
        }else {
            return false;
        }
        return false;
    }
}
