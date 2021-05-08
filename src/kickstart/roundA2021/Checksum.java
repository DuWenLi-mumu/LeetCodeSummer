package kickstart.roundA2021;

import java.util.*;

public class Checksum {
    static int[][] a;
    static int[][] b;
    static int[] r;
    static int[] c;
    static int[] father;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int count = in.nextInt();
        int now = 0;
        while (now < count){
            now++;
            int n = in.nextInt();
            a = new int[n][n];
            b = new int[n][n];
            r = new int[n];
            c = new int[n];
            father = new int[2 * n + 1];
            List<Edge> edges = new ArrayList<>();
            int[] degree = new int[2 * n + 1];//start from 1
            //store data
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                r[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
            }
            //compute edges
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] < 0){
                        edges.add(new Edge(b[i][j],n + i + 1,j + 1));
                        degree[n + i + 1]++;
                        degree[j + 1]++;
                    }
                }
            }

            boolean remove = true;
            while (remove){
                remove = false;
                for (int i = 1; i <= 2 * n ; i++) {
                    if (degree[i] == 1){
                        remove = true;
                        //remove degree = 1 edge
                        int index = 0;
                        while (index < edges.size()){
                            if (edges.get(index).i == i || edges.get(index).j == i){
                                Edge curr_edge = edges.get(index);
                                edges.remove(curr_edge);
                                degree[curr_edge.i]--;
                                degree[curr_edge.j]--;
                            }else {
                                index++;
                            }
                        }
                    }
                }
            }

            //decline
            Collections.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o2.cost - o1.cost;
                }
            });


            for (int i = 1; i <= 2 * n; i++) {
                father[i] = i;
            }

            int val = 0;
            int totoal_cost = 0;
            for (int i = 0; i < edges.size(); i++) {
                totoal_cost += edges.get(i).cost;
                int n1 = edges.get(i).i;
                int n2 = edges.get(i).j;
                if (findFather(n1) != findFather(n2)){
                    union(n1,n2);
                    val += edges.get(i).cost;
                }

            }
            System.out.println("Case #" + now + ": " + (totoal_cost - val));

        }

    }
    static int findFather(int i){
        while (father[i] != i){
            i = father[i];
        }
        return i;
    }
    static void union(int i,int j){
        int fatheri = findFather(i);
        while (father[j] != fatheri){
            int tmp = father[j];
            father[j] = fatheri;
            j = tmp;
        }
    }
    static class Edge{
        int cost;
        int i;
        int j;
        public Edge(int cost,int i,int j){
            this.cost = cost;
            this.i = i;
            this.j = j;
        }
    }

}
