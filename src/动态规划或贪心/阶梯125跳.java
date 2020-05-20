package 动态规划或贪心;

import 每日一题.跳跃游戏2;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/11 8:40
 * 每次跳2/3/5步，那么跳到n阶有多少种跳法
 */
public class 阶梯125跳 {

    public static void main(String[] args) {
        阶梯125跳 s = new 阶梯125跳();
        System.out.println(s.set(2));
    }

    public int set(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int n1 = 0, n2 = 0, n3 = 0;
            if (i - 1 >= 0) {
                n1 = dp[i - 1] + 1;
            }
            if (i - 2 >= 0) {
                n2 = dp[i - 2] + 1;
            }
            if (i - 5 >= 0) {
                n3 = dp[i - 5] + 1;
            }
            dp[i] = n1 + n2 + n3;
        }
        return dp[n-1];
    }

    public int get(int n) {//递归法
        return 0;
    }
}
