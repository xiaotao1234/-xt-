package 双周赛25;

import 其他.八皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/2 22:36
 */
public class 拥有最多糖果的孩子 {

    public static void main(String[] args) {
        拥有最多糖果的孩子 s = new 拥有最多糖果的孩子();
        s.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length == 0) {
            return new ArrayList<>();
        }
        boolean[] booleans = new boolean[candies.length];
        int max = Integer.MIN_VALUE;
        for (int s : candies) {
            max = Math.max(max, s);
        }
        int j = 0;
        for (int i : candies) {
            if (i == max) {
                booleans[j] = true;
            } else {
                if (i + extraCandies >= max) {
                    booleans[j] = true;
                }
            }
            j++;
        }
        List<Boolean> list = new ArrayList<>();
        for (boolean s : booleans) {
            list.add(s);
        }
        return list;
    }
}
