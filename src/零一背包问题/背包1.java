package 零一背包问题;

import 数组.分割等和子集;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 20:12
 */
public class 背包1 {

    public static void main(String[] args) {
        背包1 s = new 背包1();
        System.out.println(s.bebao(new int[]{1, 2, 3, 5}, new int[]{2, 4, 1, 4}, 10));
    }

    public int bebao(int[] weights, int[] jiazhi, int rl) {
        int[][] dp = new int[weights.length + 1][rl + 1];
        dp[0][0] = 0;
        for (int i = 1; i < weights.length+1; i++) {
            for (int j = weights[i-1]; j <= rl; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i-1]] + jiazhi[i-1]);
            }
        }
        return dp[weights.length][rl];
    }
}
