package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 0:38
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int s = nums[0];
        for (int i = 0; i < nums.length; i++) {
            s = s ^ nums[i];
        }
        return s;
    }
}
