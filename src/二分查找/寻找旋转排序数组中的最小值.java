package 二分查找;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/27 20:21
 */
public class 寻找旋转排序数组中的最小值 {

    public static void main(String[] args) {
        寻找旋转排序数组中的最小值 s = new 寻找旋转排序数组中的最小值();
        System.out.println(s.findMin1(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {//反转点在后半部分
                left = mid + 1;
            } else {//反转点在前半部分
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin1(int[] nums) {//错误解法，这里的错误在于使用了左边界和中点来比较。
        //左边界和中点会出现问题：
        // 1，2，3，4，5，6，7    middle>start    最小值在左边
        // 6, 7, 1, 2, 3, 4, 5   middle<start   最小值在左边  即无论middle大于start还是middle小于start都有可能在左边
        //而middle小于end   最小值在左边
        //middle大于end  最小值在右边
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {//反转点在后半部分
                left = mid + 1;
            } else {//反转点在前半部分
                right = mid;
            }
        }
        return nums[left];
    }
}
