package 动态规划或贪心;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/25 9:28
 */
public class 最长公共子序列 {

    public static void main(String[] args) {
        最长公共子序列 s = new 最长公共子序列();
        s.longestCommonSubsequence("abcde", "ace");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        for (int i = 0; i < text1.length(); i++) {
//            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
//        }
//        for (int j = 0; j < text2.length(); j++) {
//            dp[0][j] = text1.charAt(0) == text2.charAt(j) ? 1 : dp[0][j - 1];
//        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
