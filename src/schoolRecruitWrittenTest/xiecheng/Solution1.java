package schoolRecruitWrittenTest.xiecheng;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution1 {
    static int MAX = 1000000;
    static int[] nodes = new int[MAX];

    public static void main(String[] args) {
        //构建一颗二叉树，中序遍历二叉树 ; 2表示red，1表示green
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            int n = Integer.valueOf(input);
            if (n >= 1 && n <= 12) {
                buildTree(n);
                printTree(0);
                System.out.println();
            } else {
                System.out.println("O");
            }

        } catch (Exception e) {
            System.out.println("N");
        }


    }

    public static void buildTree(int n) {
        //一共有n层
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        int num = 1;
        int index = 0;
        while (n > 0) {
            n--;
            for (int i = 0; i < num; i++) {
                int color = queue.poll();
                nodes[index++] = color;
                queue.add(1);
                queue.add(2);
            }
            num *= 2;
        }
    }

    public static void printTree(int index) {
        if (index >= MAX || nodes[index] == 0) {
            return;
        }
        printTree(2 * index + 1);
        System.out.print(nodes[index] == 1 ? "G" : "R");
        printTree(2 * index + 2);
    }
}
