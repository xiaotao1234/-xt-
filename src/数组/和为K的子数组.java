package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/15 8:36
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int all = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            for (int j = i; j >= 0; j--) {
                s = s + nums[j];
                if (s == k) {
                    all++;
                }
            }
        }
        return all;
    }

    public int subarraySum1(int[] nums, int k) {//前缀和加hash
        //因为规定是连续的子数组，那么以i为右边界的子数组的满足条件的左边界的存在的数量，应该为从开始到右边界的总和减去从开始到左边界的总和
        //等于目标数k的的前缀数量，
        // 即下标0...i...j
        //若0到i的和为m1，0，j的和为m2,若目标数 = m2-m1 ==> m1 = m2-目标数；用哈希来保存每种前缀和的存在的情况
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int current = 0;
        int all = 0;
        for (int num : nums) {
            current = current + num;
            if (map.containsKey(current - k)) {
                all = all + map.get(current - k);
            }
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return all;
    }
}
