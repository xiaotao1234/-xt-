package 双周赛24;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 22:32
 */
public class 逐步求和得到正数的最小值 {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int all = 0;
        for (int i : nums) {
            all = all + i;
            min = Math.min(min, all);
        }
        if (-min + 1 <= 0) {
            return 1;
        }else {
            return -min + 1;
        }
    }
}
