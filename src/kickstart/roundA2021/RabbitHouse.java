package kickstart.roundA2021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RabbitHouse {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int count = in.nextInt();
        int now = 0;
        while (now < count){
            now++;
            int row = in.nextInt();
            int col = in.nextInt();
            boolean[][] visited = new boolean[row][col];
            int[][] house = new int[row][col];
            int max_val = 0;
            int[] max_coor = {-1,-1};
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    house[i][j] = in.nextInt();
                    if (house[i][j] > max_val){
                        max_coor[0] = i;
                        max_coor[1] = j;
                        max_val = house[i][j];
                    }
                }
            }
            //bfs, maybe there's many max_val nodes
            Queue<Node> nodes = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (house[i][j] == max_val){
                        visited[i][j] = true;
                        Node node = new Node(max_val,i,j);
                        nodes.offer(node);
                    }
                }
            }
            long res = bfs(nodes,house,visited,row,col);
            System.out.println("Case #" + now + ": " + res);
        }
    }
    public static long bfs(Queue<Node> nodes, int[][] house, boolean[][] visited, int row, int col){
        long res = 0;
        while (!nodes.isEmpty()){
            Node curr_node = nodes.poll();
            int[] x = {-1,0,1,0};
            int[] y = {0,1,0,-1};
            int should = curr_node.val - 1;//the val that point at least to be
            for (int i = 0; i < 4; i++) {// four directs add
                int new_x = curr_node.x + x[i];
                int new_y = curr_node.y + y[i];
                if (new_x >= 0 && new_x < row && new_y >= 0 && new_y < col){
                    if (!visited[new_x][new_y]){
                        if (house[new_x][new_y] >= should){
                            //do nothing
                        }else{
                            res += should - house[new_x][new_y];
                            house[new_x][new_y] = should;
                        }
                        visited[new_x][new_y] = true;
                        Node node = new Node(house[new_x][new_y],new_x,new_y);
                        nodes.offer(node);
                    }
                }
            }
            //add the same should value
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && house[i][j] == should){
                        nodes.offer(new Node(should,i,j));
                        visited[i][j] = true;
                    }
                }
            }

        }
        return res;

    }
    static class Node{
        int val;
        int x;
        int y;
        public Node(int val,int x,int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
