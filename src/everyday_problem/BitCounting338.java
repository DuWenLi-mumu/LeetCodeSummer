package everyday_problem;

public class BitCounting338 {
    private int[] res;
    public int[] countBits(int num) {
        res = new int[num + 1];
        for (int i = 0; i <= num / 2; i++) {
            res[i * 2] = res[i];
            if(i * 2 + 1 <= num)
                res[i * 2 + 1] = res[i] + 1;
        }
        return res;
    }
    public int dfs(int curr) {
        if (curr <= 1) {
            return curr;
        }
        int count = 0;
        while (curr > 0) {
            count += curr % 2;
            curr = curr >> 2;
        }
        return count;
    }
}
