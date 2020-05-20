package 每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/30 0:38
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        while (!map.contains(n)) {
            map.add(n);
            n = get(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int get(int m) {
        int l = 0;
        while (m != 0) {
            int n = m % 10;
            m = m / 10;
            l = l + n * n;
        }
        return l;
    }
}
