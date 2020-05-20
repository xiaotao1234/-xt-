package 动态规划或贪心;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/25 11:37
 */
public class 三步问题 {

    public static void main(String[] args) {
        三步问题 s = new 三步问题();
        s.waysToStep(61);
    }

    public int waysToStep(int n) {
        int s = (int) (1e9 + 7);
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%s + dp[i - 3];
            dp[i] = dp[i] % s;
        }
        return dp[n - 1] % s;
    }
}
