package 二分查找;

import 战队赛.小张刷题计划;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/27 22:17
 */
public class 寻找峰值 {
    //这道题我们可以这样理解，因为左右边界视为负无穷，我们可以看作左右两边为峰谷，而要找到峰顶就是要找到另一个爬坡的峰坡
    //然后靠两个坡来逼近峰顶
    //         /\  /\
    //    /\  /  \/  \
    //   /  \/        \
    //即我们要做的就是在为左边界找到一个 /  和为右边界找到一个  \

    public static void main(String[] args) {
        寻找峰值 s = new 寻找峰值();
        s.findPeakElement1(new int[]{1, 2, 3, 1});
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {//若中点位置为 \
                right = mid; //那么将这里逼近为右边界
            } else { //若中点位置为  /
                left = mid + 1;//  那么将这里逼近为左边界
            }
        }
        return left;
    }

//    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/find-peak-element/solution/hua-jie-suan-fa-162-xun-zhao-feng-zhi-by-guanpengc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int findPeakElement1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle - 1] < nums[middle]) {//为 /
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
