package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 15:22
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] s = new int[2];
                s[0] = i;
                s[1] = map.get(target - nums[i]);
                return s;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
