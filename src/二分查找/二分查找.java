package 二分查找;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/28 23:26
 */
public class 二分查找 {
    public static void main(String[] args) {
        二分查找 s = new 二分查找();
        s.search(new int[]{5}, 5);
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
