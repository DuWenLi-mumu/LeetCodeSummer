package dp;

/**
 * Created by 杜文丽 on 9/19/2020 3:56 PM
 **/
public class StoneGame877 {
    public boolean stoneGame(int[] piles) {
        int sum=0;
        int[][] points=new int[piles.length+1][piles.length+1];
        for (int i = 0; i <piles.length ; i++) {
            points[i][i]=0;
            sum+=piles[i];
        }
        for (int i = piles.length-2; i >=0 ; i--) {
            for (int j = i+1; j <piles.length ; j++) {
                points[i][j]=points[i+1][j-1]+Math.max(piles[i],piles[j]);
            }
        }
        if (points[0][piles.length-1]>sum/2){
            return true;
        }
        return false;
    }
}
