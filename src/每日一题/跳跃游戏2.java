package 每日一题;

import 其他.八皇后;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/4 9:03
 */
public class 跳跃游戏2 {

    public static void main(String[] args) {
        跳跃游戏2 s = new 跳跃游戏2();
        s.jump1(new int[]{2, 3, 1, 1, 4});
    }


    public int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        int left = 1;
        int right = nums[0];
        int rt = right;
        int time = 1;
        while (right < nums.length - 1) {
            for (int i = left; i <= right; i++) {
                rt = Math.max(rt, i + nums[i]);
            }
            left = right + 1;
            right = rt;
            time++;
        }
        return time;
    }

    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j < nums.length)
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }
        return dp[nums.length - 1];
    }
}
