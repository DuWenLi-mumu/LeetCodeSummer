package kickstart.roundA2021;

import java.util.Scanner;

public class K_Goodness {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int count = in.nextInt();
        int now = 0;
        while (now < count){
            now++;
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.next();
            char[] s = str.toCharArray();
            int curr = 0;
            for (int i = 0; i < n / 2; i++) {
                if (s[i] != s[n - 1 - i]){
                    curr++;
                }
            }
            if (curr > k){
                curr = k;
            }
            int res = Math.abs(k - curr);
            System.out.println("Case #" + now + ": " + res);
        }

    }
}
