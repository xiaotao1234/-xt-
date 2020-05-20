package 双周赛24;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/19 10:22
 */
public class 恢复数组 {
    public int numberOfArrays(String s, int k) {

        int n = s.length();
        long[] dp = new long[n + 1];
        int mod = 1000000007;

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, 9); j++) {
                if (s.charAt(i - j) == '0')
                    continue;
                long val = Long.valueOf(s.substring(i - j, i));
                if (val >= 1 && val <= k)
                    dp[i] = (dp[i] + dp[i - j]) % mod;
            }
        }

        return (int) dp[n];
    }
}
