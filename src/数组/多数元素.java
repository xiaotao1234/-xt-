package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/5 11:38
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {//摩尔投票法
        int target = nums[0];
        int times = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                times++;
            } else {
                times = times - 1;
                if (times == 0) {
                    target = nums[i];
                    times++;
                }
            }
        }
        return target;
    }
}
