package 二分查找;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/12 20:52
 */
public class 零到n剪1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int all = 0;
        for (int s : nums) {
            all = all + s;
        }
        int s = (nums.length) * (nums.length + 1) / 2;
        return s - all;
    }

    public int missingNumber1(int[] nums) {//二分法
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
