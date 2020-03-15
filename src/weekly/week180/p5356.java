package weekly.week180;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 3/15/2020 10:35 AM
 **/
public class p5356 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        List<Integer> res=new ArrayList<>();
        int[]x =new int[row];
        int[] y=new int[row];
        int[] val=new int[row];
        for (int i = 0; i <row ; i++) {
            val[i]=matrix[i][0];
            x[i]=i;
            y[i]=0;
            for (int j = 0; j <col ; j++) {
                if (val[i]>matrix[i][j]){
                    val[i]=matrix[i][j];
                    x[i]=i;
                    y[i]=j;
                }
            }
        }
        for (int i = 0; i <row ; i++) {
            boolean isMax=true;
            for (int j = 0; j <row ; j++) {
                if (val[i]<matrix[j][y[i]]){
                    isMax=false;
                    break;
                }
            }
            if (isMax){
                res.add(val[i]);
            }
        }
        return res;


    }
}
