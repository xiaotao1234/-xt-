package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/24 11:44
 */
public class 数组中的逆序对 {
    public int reversePairs(int[] nums) {
        devide(nums, 0, nums.length);
        return all;
    }

    int all = 0;

    public void devide(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            devide(nums, start, middle);
            devide(nums, middle + 1, end);
            all = all + mergeNums(nums, start, middle, end);
        }
    }

    public int mergeNums(int[] nums, int start, int middle, int right) {
        int[] ints = new int[right - start + 1];
        int start1 = start;
        int start2 = middle + 1;
        int index = 0;
        int all = 0;
        while (start1 <= middle && start2 <= right) {
            if (nums[start1] <= nums[start2]) {
                ints[index] = nums[start1];
                index++;
                start1++;
            } else {
                ints[index] = nums[start2];
                index++;
                start2++;
                all = all + middle - start1+1;
            }
        }
        while (start1 <= middle) {
            ints[index] = nums[start1];
            index++;
            start1++;
        }
        while (start2 <= right) {
            ints[index] = nums[start2];
            index++;
            start2++;
        }
        for (int i = start; i <= right; i++) {
            nums[i] = ints[i - start];
        }
        return all;
    }
}
