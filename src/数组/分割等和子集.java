package 数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 17:11
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        分割等和子集 s = new 分割等和子集();
        System.out.println(s.canPartition(new int[]{1, 2, 3, 5}));
    }

    public boolean canPartition(int[] nums) {
        int all = 0;
        for (int num : nums) {
            all = all + num;
        }
        return get(nums, all, 0, new HashSet<>());
    }

    public boolean get(int[] nums, int all, int now, HashSet<Integer> set) {
        if (set.size() < nums.length) {
            if (all / 2 == now) {
                return true;
            } else if (all / 2 < now) {
                return false;
            } else {
                boolean is = false;
                for (int i = 0; i < nums.length; i++) {
                    if (!set.contains(i)) {
                        set.add(i);
                        if (get(nums, all, now + nums[i], set)) {
                            is = true;
                        }
                        set.remove(i);
                    }
                }
                return is;
            }
        } else {
            return false;
        }
    }
}
