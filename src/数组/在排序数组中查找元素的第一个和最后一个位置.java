package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 22:55
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置 s1 = new 在排序数组中查找元素的第一个和最后一个位置();
        s1.searchRange(new int[]{5,7,7,8,8,10},8);
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int riight = length - 1;
        int findIndex = -1;
        while (left <= riight) {
            if (nums[(left + riight) / 2] > target) {
                riight = (left + riight) / 2 - 1;
            } else if (nums[(left + riight) / 2] < target) {
                left = (left + riight) / 2 + 1;
            } else {
                findIndex = (left + riight) / 2;
                break;
            }
        }
        if (findIndex != -1) {
            left = findIndex;
            riight = findIndex;
            for (int i = left; i >= 0; i--) {
                if (nums[i] == target) {
                    left = i;
                } else {
                    break;
                }
            }
            for (int j = riight; j < nums.length; j++) {
                if (nums[j] == target) {
                    riight = j;
                } else {
                    break;
                }
            }
        } else {
            left = -1;
            riight = -1;
        }
        return new int[]{left, riight};
    }
}
