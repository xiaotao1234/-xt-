package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/20 23:33
 */
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(set.contains(i)){
                return i;
            }else {
                set.add(i);
            }
        }
        return 0;
    }
}
