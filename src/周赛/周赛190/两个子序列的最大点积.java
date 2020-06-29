package 周赛190;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/24 11:19
 */
public class 两个子序列的最大点积 {

    public static void main(String[] args) {
        两个子序列的最大点积 s = new 两个子序列的最大点积();
        System.out.println(s.maxDotProduct(new int[]{2,1,-2,5}, new int[]{3,0,-6}));
    }


    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = nums1[i] * nums2[j];
                } else {
                    if (i == 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], nums2[j] * nums1[i]);
                    } else if (j == 0) {
                        for (int m = i; m > 0; m--) {
                            dp[i][j] = Math.max(dp[i][j], nums1[m] * nums2[j]);
                        }
                    } else {
                        int max = Integer.MIN_VALUE;
                        for (int m = i; m > 0; m--) {
                            max = Math.max(Math.max(dp[m - 1][j - 1], 0) + nums2[j] * nums1[m], max);
                        }
                        max = Math.max(max, nums1[0] * nums2[j]);
                        dp[i][j] = Math.max(max, dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
