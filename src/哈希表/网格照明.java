package 哈希表;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/16 18:06
 */
public class 网格照明 {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] s = new int[]{1, -1, 0};
        int[] q = new int[]{1, -1, 0};
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] ints : lamps) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(ints[1]);
                map.put(ints[0], set);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i][0]) && map.get(queries[i][0]).contains(queries[i][1])) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            for (int m : s) {
                for (int n : q) {
                    int x = queries[i][0] + m;
                    int y = queries[i][1] + n;
                    if (x >= 0 && y >= 0 && x < N && y < N) {
                        if (map.containsKey(x)) {
                            map.get(x).remove(y);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
