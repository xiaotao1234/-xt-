package 字符串;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 23:30
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int target = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                target = i - 1;
                break;
            }
        }
        if (target == -1) {
            sort(nums);
        } else {
            int minIndex = target + 1;
            for (int i = target + 2; i < nums.length; i++) {
                if (nums[i] > nums[target] && nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            int s = nums[minIndex];
            nums[minIndex] = nums[target];
            nums[target] = s;
            for (int i = target + 1; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        int m = nums[i];
                        nums[i] = nums[j];
                        nums[j] = m;
                    }
                }
            }
        }
    }

    public void sort(int[] nums) {//冒泡
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int s = nums[i];
                    nums[i] = nums[j];
                    nums[j] = s;
                }
            }
        }
    }

    public void sort1(int[] nums) {//插入
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int s = nums[i];
                for (int j = i; j >= 0; j++) {
                    if (nums[j] > s) {
                        nums[j + 1] = nums[j];
                    } else {
                        nums[j + 1] = s;
                    }
                }
            }
        }
    }
}
