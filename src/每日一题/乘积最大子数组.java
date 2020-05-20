package 每日一题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/18 8:46
 */
public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int zMax = 1;
        int fMax = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {//若当前元素小于0，则这个数的加入会让正负的端值发生交换，所以要先处理这个交换
                int s = zMax;
                zMax = fMax;
                fMax = s;
            }
            zMax = Math.max(zMax * nums[i], nums[i]);//这之前的能连起来的最大端值*当前元素  和  只加入当前元素做比较，找到最大值，（因为前值可能小于1，或者大于-1）就会导致当前值 若乘上了前面的一段连续值，值反而会缩小
            fMax = Math.min(fMax * nums[i], nums[i]);//同上
            max = Math.max(max, zMax);//一个当前记录的最大值
        }
        return max;
    }
}
