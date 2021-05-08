package schoolRecruitWrittenTest.Alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] dis = new int[n + 1][n + 1];
        List<List<Integer>> p= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int dist = in.nextInt();
            dis[n1][n2] = dist;
            dis[n2][n1] = dist;
        }
        for (int i = 0; i < 3; i++) {
            int p_num = in.nextInt();
            List<Integer> person = new ArrayList<>();
            for (int j = 0; j <p_num ; j++) {
                person.add(in.nextInt());
            }
            p.add(person);
        }


    }
}
