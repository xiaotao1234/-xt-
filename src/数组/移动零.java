package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/15 23:55
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int s : nums) {
            if (s == 0) {
            } else {
                nums[start] = s;
                start++;
            }
        }
        for (int i = start + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
