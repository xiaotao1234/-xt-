package 二刷冲冲冲.动态规划;

/**
 * @author xt
 * @version 1.0
 * @date 2020/6/1 10:31
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0] = 0;
                dp[1] = -prices[i];
            } else {
                dp[0] = Math.max(dp[1] + prices[i], dp[0]);
                dp[1] = Math.max(dp[1], -prices[i]);
            }
        }
        return dp[0];
    }
}
