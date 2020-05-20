package 数学;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/21 21:40
 */
public class 快乐数 {



    public boolean isHappy(int n) {
        int m = n, k = n;
        do {
            m = get(m);
            k = get(k);
            k = get(k);
        } while (m != k);
        if (m == 1) {
            return true;
        }
        return false;
    }

    public int get(int n) {
        int all = 0;
        while (n != 0) {
            int l = n % 10;
            n = n / 10;
            all = all + l * l;
        }
        return all;
    }
}
