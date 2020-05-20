package 周赛185;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/19 11:14
 */
public class 生成数组 {

    public static void main(String[] args) {
        生成数组 s = new 生成数组();
        System.out.println(s.numOfArrays(37,14,7));
    }

    int s = 1000000000 + 7;
    int all = 0;

    public int numOfArrays(int n, int m, int k) {
        if (m <= 1 && k > 0) {
            return 0;
        }
        for (int i = 1; i <= m; i++) {
            get(n, m, k, i, 1, 1);
        }
        return all;
    }

    public void get(int n, int m, int k, int now, int number, int cost) {
        if (number == n) {
            if(cost == k)
            all = all % s + 1;
            return;
        }
        if (cost < k) {
            if (now + 1 <= m)
                get(n, m, k, now + 1, number + 1, cost + 1);
            get(n, m, k, now, number + 1, cost);
            if (now - 1 >= 1)
                get(n, m, k, now - 1, number + 1, cost);
        } else {
            get(n, m, k, now, number + 1, cost);
            if (now - 1 >= 1)
                get(n, m, k, now - 1, number + 1, cost);
        }
    }

    private static int mod = (int)1e9 + 7;

    private int n, m, k;

    public int numOfArrays1(int n, int m, int k) {
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        long res = 0;
        this.m = m;
        this.n = n;
        this.k = k;
        for(int i = 1; i <= m ; i++){
            res += dfs(dp, 1, i, k - 1);
            res %= mod;
        }
        return (int)res;
    }

    private long dfs(long[][][] dp, int cur, int max, int k){ // 分别表示当前的位置，截至目前最大的元素，剩余的峰值数量
        if(cur == n){
            return k == 0 ? 1: 0; //判断是否符合条件
        }
        if(dp[cur][max][k] != -1){
            return dp[cur][max][k];
        }
        dp[cur][max][k] = dfs(dp, cur + 1, max, k) * max % mod; //可选max个非峰值数
        if(k > 0){
            for(int i = max + 1; i <= m ; i++){  // 依次遍历可选的峰值
                dp[cur][max][k] += dfs(dp, cur + 1, i, k - 1);
                dp[cur][max][k] %= mod;
            }
        }
        return dp[cur][max][k];
    }

//    作者：HenryLee4
//    链接：https://leetcode-cn.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/solution/dong-tai-gui-hua-java-by-henrylee4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
