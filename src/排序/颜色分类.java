package 排序;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/16 17:15
 */
public class 颜色分类 {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int target = nums[j];
                    nums[j] = nums[i];
                    nums[i] = target;
                }
            }
        }
    }
}
