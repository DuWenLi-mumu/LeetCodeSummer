package dfs;

/**
 * Created by 杜文丽 on 8/2/2020 9:33 PM
 **/
public class SurroundedRegions130 {
    int[] x={0,1,0,-1};
    int[] y={-1,0,1,0};
    char[][] board;
    int len=0;
    public void solve(char[][] board) {
        this.board=board;
        this.len=board[0].length;
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len ; j++) {
                if (board[i][j]=='O'){
                    boolean wall=false;
                    for (int k = 0; k <4 ; k++) {
                        int curx=i+x[k];
                        int cury=j+y[k];
                        if (curx<0||cury<0||curx>=len||cury>=len){
                            wall=true;
                            break;//周围有墙 不能被包围
                        }
                        if (board[curx][cury]=='O'){
                            Result result=judge(curx,cury,new int[]{i,j});
                            if (result.good){
                                continue;
                            }else {
                                wall=true;
                                break;
                            }
                        }
                    }
                    if (!wall){
                        board[i][j]='X';
                    }
                }
            }
        }
        board=this.board;
    }
    Result judge(int xx,int yy,int[]uncheckDirection){
        Result result=new Result();
        boolean wall=false;
        for (int i = 0; i <4 ; i++) {
            int currx=xx+x[i];
            int curry=yy+y[i];
            if (currx==uncheckDirection[0]&&curry==uncheckDirection[1]){
                wall=true;
                break;
            }
            if (currx<0||curry>=len||curry<0||currx>=len){
                continue;
            }
            if (board[currx][curry]=='O'){
                result.good=false;
                result.xy= new int[]{currx, curry};
                return result;
            }
        }
        result.good=true;
        return result;
    }
}
class Result{
    public boolean good=false;
    public int[] xy={0,0};
}
