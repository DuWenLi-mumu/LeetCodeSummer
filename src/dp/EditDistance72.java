package dp;

/**
 * Created by 杜文丽 on 9/9/2020 4:45 PM
 **/
public class EditDistance72 {
    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        EditDistance72 distance72=new EditDistance72();
        distance72.minDistance(word1,word2);
    }
    public int minDistance(String word1, String word2) {
        int len = Math.max(word1.length(), word2.length());
        int[][] lev = new int[len + 1][len + 1];
        for (int i = 0; i <= word1.length(); i++) {
            lev[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            lev[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                lev[i][j] = Math.min(lev[i - 1][j] + 1, lev[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    lev[i][j]=lev[i-1][j-1];
                }else {

                    lev[i][j] = Math.min(lev[i][j], lev[i - 1][j - 1] + 1);
                }
            }
        }
        return lev[word1.length()][word2.length()];
    }
}
