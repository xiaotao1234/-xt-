package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/27 8:58
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {//解题方法，无限分割，分割后对左右两边有序的一边中去找，若在其范围内则继续查找，否则到另一边无序的之中去找，然后对无序的一边再次区分有序无序的左右两边
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {//若前部分有序
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {//判断target是否在前半部分的范围内
                    end = mid - 1;//若在则直接将范围移到前半部分区域
                } else {//若不在前半部分范围内，则若存在一定在另外无序的一部分里
                    start = mid + 1;//将范围移动到后半部分范围内
                }
            } else {//同上
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
//        作者：reedfan
//        链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] < nums[mid]) {//前有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}























