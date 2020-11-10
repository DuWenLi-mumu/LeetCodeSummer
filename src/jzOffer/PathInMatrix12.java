package jzOffer;

/**
 * Created by 杜文丽 on 11/9/2020 11:25 PM
 **/
public class PathInMatrix12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length == 0){
            return false;
        }
        if (word.length() < 1){
            return true;
        }
        //bfs实现
        char[] s = word.toCharArray();
        int index = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (sub(visited,board,s,index,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean sub(boolean[][] visited,char[][] board,char[] s,int index,int i,int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || s[index] != board[i][j]){
            return false;
        }
        index++;
        if (index >= s.length){
            return true;
        }
        visited[i][j] = true;
        if (sub(visited,board,s,index,i-1,j) || sub(visited,board,s,index,i+1,j) || sub(visited,board,s,index,i,j - 1) || sub(visited,board,s,index,i,j + 1)){
            return true;
        }else {
            visited[i][j] = false;
            return false;
        }
    }
}
