package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 21:18
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        get(list, nums);
        return lists;
    }

    public void get(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                get(list, nums);
                list.remove(list.size()-1);
            }
        }
    }

    List<List<Integer>> lists = new ArrayList<>();
}
