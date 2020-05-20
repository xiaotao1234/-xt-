package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/25 9:23
 */
public class 全排列2 {
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        get(nums, new ArrayList<>());
        return lists;
    }

    List<List<Integer>> lists;

    public void get(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int m : nums) {
            if (!list.contains(m)) {
                list.add(m);
                get(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
