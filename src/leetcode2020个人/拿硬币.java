package leetcode2020个人;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 15:00
 */
public class 拿硬币 {
    public int minCount(int[] coins) {
        int all = 0;
        for (int i : coins) {
            all = all+get(i);
        }
        return all;
    }

    public int get(int co) {
        if (co % 2 == 1) {
            return co / 2 + 1;
        } else {
            return co / 2;
        }
    }
}
