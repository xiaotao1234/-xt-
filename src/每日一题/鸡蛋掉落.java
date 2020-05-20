package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/11 0:03
 */
public class 鸡蛋掉落 {

    public static void main(String[] args) {
        鸡蛋掉落 s = new 鸡蛋掉落();
        System.out.println(s.superEggDrop2(3, 14));
    }

    /**
     * 鸡蛋掉落，鹰蛋（Leetcode 887）：（经典dp）
     * 有 K 个鸡蛋，有 N 层楼，用最少的操作次数 F 检查出鸡蛋的质量。
     *
     * 思路：
     * 本题应该逆向思维，若你有 K 个鸡蛋，你最多操作 F 次，求 N 最大值。
     *
     * dp[k][f] = dp[k][f-1] + dp[k-1][f-1] + 1;
     * 解释：
     * 0.dp[k][f]：如果你还剩 k 个蛋，且只能操作 f 次了，所能确定的楼层。
     * 1.dp[k][f-1]：蛋没碎，因此该部分决定了所操作楼层的上面所能容纳的楼层最大值
     * 2.dp[k-1][f-1]：蛋碎了，因此该部分决定了所操作楼层的下面所能容纳的楼层最大值
     * 又因为第 f 次操作结果只和第 f-1 次操作结果相关，因此可以只用一维数组。
     *
     * 时复：O(K*根号(N))
     */
    public int superEggDrop2(int K, int N) {//很6很666666666666666666666666
        int[] dp = new int[K + 1];
        int ans = 0;    // 操作的次数
        while (dp[K] < N){
            for (int i = K; i > 0; i--) // 从后往前计算
                dp[i] = dp[i] + dp[i-1] + 1;
            ans++;
        }
        return ans;
    }


    public int superEggDrop(int K, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        return get(N, K, map);
    }

    public int get(int n, int K, Map<Integer, Integer> map) {
        if (map.containsKey(n*10000+K)) {
            return map.get(n*10000+K);
        }
        if (K == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        int now = n;
        for (int i = 1; i <= n + 1; i++) {
            now = Math.min(now, Math.max(get(i - 1, K - 1, map), get(n - i, K, map)) + 1);
        }
        map.put(n*10000+K, now);
        return now;
    }

    class node {
        int n;
        int K;

        @Override
        public boolean equals(Object obj) {
            node node = (node)obj;
            if (this.n == node.n && this.K == node.K) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return n + K;
        }

        public node(int n, int k) {
            this.n = n;
            K = k;
        }
    }


    public class Solution {

        public int superEggDrop(int K, int N) {

            // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少实验的次数
            // 注意：
            // 1、i 表示的是楼层的大小，不是第几层的意思，例如楼层区间 [8, 9, 10] 的大小为 3，这一点是在状态转移的过程中调整的定义
            // 2、j 表示可以使用的鸡蛋的个数，它是约束条件，我个人习惯放在后面的维度，表示消除后效性的意思

            // 0 个楼层和 0 个鸡蛋的情况都需要算上去，虽然没有实际的意义，但是作为递推的起点，被其它状态值所参考
            int[][] dp = new int[N + 1][K + 1];

            // 由于求的是最小值，因此初始化的时候赋值为一个较大的数，9999 或者 i 都可以
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], i);
            }

            // 初始化：填写下标为 0、1 的行和下标为 0、1 的列
            // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
            for (int j = 0; j <= K; j++) {
                dp[0][j] = 0;
            }

            // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
            dp[1][0] = 0;
            for (int j = 1; j <= K; j++) {
                dp[1][j] = 1;
            }

            // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
            // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）
            for (int i = 0; i <= N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            // 从第 2 行，第 2 列开始填表
            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= K; j++) {
                    for (int k = 1; k <= i; k++) {
                        // 碎了，就需要往低层继续扔：层数少 1 ，鸡蛋也少 1
                        // 不碎，就需要往高层继续扔：层数是当前层到最高层的距离差，鸡蛋数量不少
                        // 两种情况都做了一次尝试，所以加 1
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                    }
                }
            }
            return dp[N][K];
        }
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
