package schoolRecruitWrittenTest.tx;

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        int[][] sum = new int[m][n];
        for (int j = 0; j < n; j++) {
            sum[0][j] = mat[0][j];
            for (int i = 1; i < m; i++) {
                sum[i][j] += sum[i - 1][j] + mat[i][j];
            }
        }
        int cont = 0;
        for (int i = 0; i < m; i++) {
            for (int p = i; p < m; p++) {
                for (int k = 0; k <= n; k++) {//以k结尾的矩形
                    if (k == n) {
                        if (cont > 0) {
                            ans += (cont + 1) * cont / 2;
                            cont = 0;
                            continue;
                        }
                    }
                    if (p - i + 1 == (sum[p][k] - sum[i][k] + 1) && mat[i][k] == 1 && mat[p][k] == 1) {
                        cont++;
                    } else {
                        ans += (cont + 1) * cont / 2;
                        cont = 0;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] num = {{1, 0, 1}, {0, 1, 1}, {1, 0, 1}};
        test.numSubmat(num);
    }
}
