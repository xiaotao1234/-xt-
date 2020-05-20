package 每日一题;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 15:29
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.get(nums[i]).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (map.containsKey(-nums[i] - nums[j])) {
                    List<Integer> list = map.get(-nums[i] - nums[j]);
                    for (int s : list) {
                        if (s != i && s != j && i != j) {
                            List<Integer> list1 = new ArrayList<>();
                            list1.add(nums[i]);
                            list1.add(nums[j]);
                            list1.add(nums[s]);
                            Collections.sort(list1);
                            if (!lists.contains(list1))
                                lists.add(list1);
                        }
                    }
                }
            }
        }
        return lists;
    }
}
