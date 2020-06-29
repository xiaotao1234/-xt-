package 周赛186;


/**
 * @author xt
 * @version 1.0
 * @date 2020/4/29 16:54
 */
public class 带限制的子序列和 {

    public static void main(String[] args) {
        带限制的子序列和 s = new 带限制的子序列和();
        s.constrainedSubsetSum(new int[]{-1, -2, -3}, 1);
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + k];
        for (int i = 0; i < k; i++) {
            dp[i] = nums[0];
        }
        dp[k] = nums[0];
        for (int i = k + 1; i < nums.length + k; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i] = Math.max(dp[i - j] + nums[i - k], dp[i]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
