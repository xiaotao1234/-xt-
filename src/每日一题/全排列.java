package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/24 17:43
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        get(nums, new ArrayList<>());
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    public void get(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i : nums) {
            if (!list.contains(i)) {
                list.add(i);
                get(nums, list);
                list.remove(i);
            }
        }
    }
}
