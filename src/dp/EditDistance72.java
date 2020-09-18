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
        int[][] dp_table=new int[len+1][len+1];
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
                dp_table[i][j]=lev[i][j];
            }
        }
        return lev[word1.length()][word2.length()];
    }
//    public int minDistance(String word1, String word2) {
//        int[][] dp=new int[word1.length()+1][word2.length()+1];
//        for(int i=0;i<=word1.length();i++){
//            dp[i][0]=i;
//        }
//        for(int i=0;i<=word2.length();i++){
//            dp[0][i]=i;
//        }
//        for(int i=1;i<=word1.length();i++){
//            for(int j=1;j<=word2.length();j++){
//                dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
//                if(word1.charAt(i-1)==word2.charAt(j-1)){
//                    dp[i][j]=dp[i-1][j-1];//相等不做改变
//                }else{
//
//                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+1);
//                }
//            }
//        }
//        return dp[word1.length()][word2.length()];
//    }
}
