package 动态规划或贪心;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//示例 1:
//
//输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//示例 2:
//
//输入: coins = [2], amount = 3
//输出: -1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/coin-change
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 零钱兑换 {//相似题型最低票价

    public static void main(String[] args) {
        零钱兑换 s = new 零钱兑换();
        System.out.println(s.coinChange4(new int[]{3}, 9));
    }

    public int coinChange4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {//因为是从1到amount，又因为i-x<i,那么在遍历到i时，i-x一定已经被遍历了，
            //即若i-x存在解，那么就一定已经找出，这也是动态规划可持续向前推进的根本，
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    //若dp[i-coin]未能找到解，那么其目前依然是amount+1，那么对其加1再来加入取最小值，永远不会被取上；
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }

    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];//要定义一个基本量即0个硬币
        Arrays.fill(dp, amount + 1);//初始时将所有都置为总金额+1,因为这个数字是永远达不到的硬币数，
        // 如果我们再返回时发现这个值为amount+1，那么就标志着当前的金额用现有的硬币无法拼出来，返回-1；
        dp[0] = 0;//金额为0时硬币数为0，作为后续一个硬币的加的基础。
        for (int j = 1; j <= amount; j++) {//对金额进行遍历，即逐步dp的过程，相似题型最低票价相比，最低票价是逆向dp
            for (int s : coins) {
                if (j - s >= 0 && dp[j - s] != amount) {
                    dp[j] = Math.min(dp[j], dp[j - s] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else
            return dp[amount];
    }

    public int dod(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int s = get(coins, amount, 0);
        if (s == Integer.MAX_VALUE) {
            return -1;
        }
        return s;
    }

    public int get(int[] coins, int amount, int num) {
        if (amount == 0) {
            return num;
        } else if (amount < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int s = get(coins, amount - coin, num + 1);
            if (s < 0) {
                continue;
            }
            min = Math.min(min, s);
        }
        return min;
    }

    int res = Integer.MAX_VALUE;

    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        findWay(coins, amount, 0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int i = 0; i < coins.length; i++) {
            findWay(coins, amount - coins[i], count + 1);
        }
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i] != amount + 1) {
                    dp[i] = Math.min(dp[i - coin], dp[i]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }

//    作者：sugar-31
//    链接：https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}

















