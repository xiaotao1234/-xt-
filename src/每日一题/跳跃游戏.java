package 每日一题;

import 数组.缺失的第一个正数;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 0:01
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        跳跃游戏 s1 = new 跳跃游戏();
        System.out.println(s1.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int right = nums[0];
        int now = 0;
        while (right > now) {
            for (int i = now; i <= right; i++) {
                if (i < nums.length && i + nums[i] > right) {
                    right = i + nums[i];
                    if (right > nums.length) {
                        return true;
                    }
                }
                if (right >= nums.length) {
                    return true;
                }
            }
            now = right;
        }
        return false;

    }


}
