package 每日一题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/23 0:03
 */
public class 硬币 {
    public int waysToChange1(int n) {
        int[][] dp = new int[4][n + 1];
        int[] coins = {1, 5, 10, 25};
        for (int i = 0; i <= n; i++)
            dp[0][i] = 1;
        for (int i = 0; i < 4; i++)
            dp[i][0] = 1;

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i])
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i]]) % 1000000007;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[3][n];
    }

//    作者：yuanninesuns
//    链接：https://leetcode-cn.com/problems/coin-lcci/solution/dong-tai-gui-hua-jian-dan-yi-dong-by-yuanninesuns/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int waysToChange(int n) {
        int[][] dp = new int[4][n + 1];//dp[i][j] i:代表当前取的是哪个硬币，j代表当前金额
        int[] ints = new int[]{1, 5, 10, 25};
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;//第一枚硬币组成任意的数量的钱都只有一种方案1，1，1，1，1
        }
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;//任意的硬币组成0金额都只有一种方案，一个都不取
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= ints[i]) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - ints[i]]) % 1000000007;//在其上一种币的基础上，金额为j的对当前硬币取或不取，不取则在上一种方案及其以前的币种的基础上，取则从当前钱币
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[3][n];
    }
}
