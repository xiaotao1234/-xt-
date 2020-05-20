package 二分查找;

import 战队赛.小张刷题计划;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/25 22:46
 */
public class 分割数组的最大值 {

    public static void main(String[] args) {
        分割数组的最大值 s = new 分割数组的最大值();
//        s.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
    }

//    public int splitArray(int[] nums, int m) {
//        int left = -1;
//        int right = 0;
//        for (int i : nums) {
//            left = Math.max(left, i);
//            right = right + i;
//        }//范围值的左边界
//        if (m == 1) {
//            return right;
//        }
//        int middle = (left + right) / 2;
//        int z = 0;
//        int max = 0;
//        while (z < m) {
//            int s = 0;
//            z = 0;
//            max = 0;
//            for (int i = 0; i < nums.length; i++) {
//                s = s + nums[i];
//                if (s > middle) {
//                    max = Math.max(max, s - nums[i]);
//                    i--;
//                    s = 0;
//                    z++;
//                }
//            }
//            if (s != 0) {
//                z++;
//            }
//            if ()
//        }
//        return max;
//    }
}
