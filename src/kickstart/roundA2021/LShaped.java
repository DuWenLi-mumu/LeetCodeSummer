package kickstart.roundA2021;


import java.util.Scanner;

public class LShaped {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int num = 0;

        while (num < count) {
            int res = 0;
            num++;
            int row = in.nextInt();
            int col = in.nextInt();
            int[][] dots = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    dots[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (dots[i][j] == 0) {
                        continue;
                    }
                    Node node = compute_node(dots, row, col, i, j);
                    //up short
                    for (int k = 2; k <= node.up; k++) {
                        if (node.left >= k * 2) {
                            res++;
                        }
                        if (node.right >= k * 2) {
                            res++;
                        }
                    }
                    //down short
                    for (int k = 2; k <= node.down; k++) {
                        if (node.left >= k * 2) {
                            res++;
                        }
                        if (node.right >= k * 2) {
                            res++;
                        }
                    }
                    //left short
                    for (int k = 2; k <= node.left; k++) {
                        if (node.up >= k * 2) {
                            res++;
                        }
                        if (node.down >= k * 2) {
                            res++;
                        }
                    }
                    //right short
                    for (int k = 2; k <= node.right; k++) {
                        if (node.up >= k * 2) {
                            res++;
                        }
                        if (node.down >= k * 2) {
                            res++;
                        }
                    }
                }
            }
            System.out.println("Case #" + num + ": " + res);
        }
    }
    public static Node compute_node(int[][] dots, int row, int col, int i, int j) {
        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;
        int x = i;
        int y = j;

        //up
        while (--x >= 0 && dots[x][y] == 1) {
            up++;
        }
        x = i;
        y = j;
        //down
        while (++x < row && dots[x][y] == 1) {
            down++;
        }
        x = i;
        y = j;
        //left
        while (--y >= 0 && dots[x][y] == 1) {
            left++;
        }
        x = i;
        y = j;
        //right
        while (++y < col && dots[x][y] == 1) {
            right++;
        }
        Node node = new Node(up, down, left, right);
        return node;
    }
    static class Node {
        int up;
        int down;
        int left;
        int right;
        public Node(int up, int down, int left, int right) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }
}
