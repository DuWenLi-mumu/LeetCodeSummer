package everyday_problem;

/**
 * Created by 杜文丽 on 3/26/2020 7:23 PM
 **/
public class AvailableCapturesForRook999 {
    public int numRookCaptures(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int rx=-1;
        int ry=-1;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (board[i][j]=='R'){
                    rx=i;
                    ry=j;
                    break;
                }
            }
        }
        if (rx==-1||ry==-1){
            return 0;
        }
        int tmpx=rx-1;
        int tmpy=ry;
        int res=0;
        //往上走
        while (tmpx>=0){
            if (board[tmpx][tmpy]=='B'){
                break;
            }else if (board[tmpx][tmpy]=='p'){
                res++;
                break;
            }
            tmpx--;
        }
        //往下走
        tmpx=rx+1;
        tmpy=ry;
        while (tmpx<m){
            if (board[tmpx][tmpy]=='B'){
                break;
            }else if (board[tmpx][tmpy]=='p'){
                res++;
                break;
            }
            tmpx++;
        }
        //往左走
        tmpx=rx;
        tmpy=ry-1;
        while (tmpy>=0){
            if (board[tmpx][tmpy]=='B'){
                break;
            }else if (board[tmpx][tmpy]=='p'){
                res++;
                break;
            }
            tmpy--;
        }
        //往右走
        tmpx=rx;
        tmpy=ry+1;
        while (tmpy<n){
            if (board[tmpx][tmpy]=='B'){
                break;
            }else if (board[tmpx][tmpy]=='p'){
                res++;
                break;
            }
            tmpy++;
        }
        return res;

    }
}
